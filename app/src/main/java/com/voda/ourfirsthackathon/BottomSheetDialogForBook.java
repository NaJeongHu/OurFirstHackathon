package com.voda.ourfirsthackathon;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialogForBook extends BottomSheetDialogFragment implements View.OnClickListener{

    private View view;
    private Button btn_hide_bt_sheet;
    private String temp;
    private ConstraintLayout bottom_sheet;
    private AppCompatButton btn1, btn2, btn3, btn4;
    private CardView card_pay;
    private TextView tv_time_forbook;

    private String[] price = {"1시간","2시간","3시간","4시간"};
    private int i=0;

    public BottomSheetDialogForBook(String temp) {
        this.temp = temp;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogForBook.STYLE_NORMAL, R.style.BottomSheet_forbook);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet_layout_forbook, container, false);


        btn1 = view.findViewById(R.id.btn_1);
        btn2 = view.findViewById(R.id.btn_2);
        btn3 = view.findViewById(R.id.btn_3);
        btn4 = view.findViewById(R.id.btn_4);

        card_pay = view.findViewById(R.id.card_pay);

        tv_time_forbook = view.findViewById(R.id.tv_time_forbook);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        card_pay.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.card_pay:
                dismiss();
                PayActivity payActivity = new PayActivity("청암 초등학교", "실내코트 이용료", 40000);
                Intent intent = new Intent(getActivity(), payActivity.getClass());
                startActivity(intent);

            case R.id.btn_1:
                btn1.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.shape_clicked));
                btn1.setTextColor(Color.WHITE);
                if(i<4){
                    i++;
                    tv_time_forbook.setText(price[i-1]);
                }
                break;

            case R.id.btn_2:
                btn2.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.shape_clicked));
                btn2.setTextColor(Color.WHITE);
                if(i<4){
                    i++;
                    tv_time_forbook.setText(price[i-1]);
                }
                break;

            case R.id.btn_3:
                btn3.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.shape_clicked));
                btn3.setTextColor(Color.WHITE);
                if(i<4){
                    i++;
                    tv_time_forbook.setText(price[i-1]);
                }
                break;

            case R.id.btn_4:
                btn4.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.shape_clicked));
                btn4.setTextColor(Color.WHITE);
                if(i<4){
                    i++;
                    tv_time_forbook.setText(price[i-1]);
                }
                break;


        }
    }
}
