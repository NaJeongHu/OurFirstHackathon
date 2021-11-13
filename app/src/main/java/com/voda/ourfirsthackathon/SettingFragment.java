package com.voda.ourfirsthackathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SettingFragment extends Fragment implements View.OnClickListener{

    private FirebaseAuth mFirebaseAuth;     // 파이어베이스 인증
    private DatabaseReference mDatabaseRef; // 실시간 데이터베이스
    private FirebaseUser mFirebaseUser;

    private LinearLayout linear_auth;

    //dialog UI
    private LinearLayout linear_call;
    private Button btn_okay;

    public SettingFragment() { }

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        linear_auth = view.findViewById(R.id.linear_auth);
        linear_auth.setOnClickListener(this);
        return view;
    }

    private void init(){
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("hackathon");
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        //todo 파이어베이스에서 Auth 값 가져와서 false인 경우, true인 경우 뷰 조절

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linear_auth:
                auth_dialog(v);
                break;
        }
    }

    public void auth_dialog(View v) {

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_auth, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setView(dialogView);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        WindowManager.LayoutParams params = alertDialog.getWindow().getAttributes();
        alertDialog.getWindow().setAttributes(params);
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.white);

        linear_call = dialogView.findViewById(R.id.linear_call);
        btn_okay = dialogView.findViewById(R.id.btn_okay_dialog_auth);

        linear_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:01077395570")));
            }
        });
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}