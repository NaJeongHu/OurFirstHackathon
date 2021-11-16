package com.voda.ourfirsthackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialogForBook extends BottomSheetDialogFragment {

    private View view;
    private Button btn_hide_bt_sheet;
    private String temp;
    private ConstraintLayout bottom_sheet;

    public BottomSheetDialogForBook(String temp) {
        this.temp = temp;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogForBook.STYLE_NORMAL,R.style.BottomSheet_forbook);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet_layout_forbook,container,false);

        /*
        //btn_hide_bt_sheet = view.findViewById(R.id.btn_hide_bt_sheet);
        btn_hide_bt_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                PayActivity payActivity = new PayActivity("storeName", "name", 1313);
                Intent intent = new Intent(getActivity(), payActivity.getClass());
                startActivity(intent);
            }
        });
        */

        return view;
    }

}
