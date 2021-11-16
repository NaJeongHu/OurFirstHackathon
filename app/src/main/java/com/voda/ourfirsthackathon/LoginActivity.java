package com.voda.ourfirsthackathon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mFirebaseAuth;     // 파이어베이스 인증
    private EditText mEtEmail, mEtPassword;
    private CardView mBtnLogin, cardview_login_underinfo;
    private TextView mTvJoin;

    private AlertDialog alertDialog;
    private LottieAnimationView animationView;
    private Animation startAnim, endAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    private void init() {
        mEtEmail = findViewById(R.id.edit_login_email);
        mEtPassword = findViewById(R.id.edit_login_password);
        mBtnLogin = findViewById(R.id.btn_login);
        mTvJoin = findViewById(R.id.btn_join);

        cardview_login_underinfo = findViewById(R.id.cardview_login_underinfo);
        startAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_downtoup);
        endAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_uptodown);
        cardview_login_underinfo.startAnimation(startAnim);

        mBtnLogin.setOnClickListener(this);
        mTvJoin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String strEmail = mEtEmail.getText().toString();
                String strPassword = mEtPassword.getText().toString();

                if(TextUtils.isEmpty(strEmail)){
                    Toast.makeText(LoginActivity.this, "이메일을 입력하세요", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(strPassword)){
                    Toast.makeText(LoginActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    upload_dialog(view);
                    mFirebaseAuth.signInWithEmailAndPassword(strEmail,strPassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // 로그인 성공
//                                alertDialog.dismiss();

                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable()  {
                                    public void run() {
                                        alertDialog.dismiss();
                                        cardview_login_underinfo.startAnimation(endAnim);
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                                        finish();   // 현재 엑티비티 파괴
                                    }
                                }, 1800); // 2초후

//                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                startActivity(intent);
//                                finish();   // 현재 엑티비티 파괴
                            } else {
                                alertDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "로그인 실패",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;

            case R.id.btn_join:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }


    public void upload_dialog(View v) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_progress, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setView(dialogView);

        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.show();

        animationView = dialogView.findViewById(R.id.lottie_progress);
        animationView.playAnimation();
    }
}