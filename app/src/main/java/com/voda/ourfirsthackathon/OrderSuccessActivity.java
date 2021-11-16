package com.voda.ourfirsthackathon;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class OrderSuccessActivity extends AppCompatActivity {

    private CardView mBtnToHome;
    private LottieAnimationView lottie_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        init();
    }

    public void init() {
        mBtnToHome = findViewById(R.id.btn_order_success_home);
        mBtnToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderSuccessActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        lottie_success = findViewById(R.id.lottie_success);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable()  {
            public void run() {
                lottie_success.playAnimation();
            }
        }, 1800); // 2초후


        lottie_success.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                lottie_success.pauseAnimation();
                //lottie_success.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }
}