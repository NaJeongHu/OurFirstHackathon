package com.voda.ourfirsthackathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    //UI
    private View view;


    private ViewPager viewPager_school_picture;
    private PagerAdapter_Picture adapter;
    private ArrayList<Integer> pictures;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialog.STYLE_NORMAL,R.style.BottomSheet);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet_layout,container,false);

        pictures = new ArrayList<>();
        pictures.add(R.drawable.school1);
        pictures.add(R.drawable.school2);
        pictures.add(R.drawable.school3);

        viewPager_school_picture = view.findViewById(R.id.viewPager_school_picture);

        adapter = new PagerAdapter_Picture(pictures, getContext());

        viewPager_school_picture.setAdapter(adapter);

        return view;
    }

}
