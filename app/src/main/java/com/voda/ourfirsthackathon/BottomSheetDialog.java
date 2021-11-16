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

import me.relex.circleindicator.CircleIndicator;
import soup.neumorphism.NeumorphCardView;

public class BottomSheetDialog extends BottomSheetDialogFragment implements View.OnClickListener{

    //UI
    private View view;
    private ViewPager viewPager_school_picture;
    private PagerAdapter_Picture adapter;
    private ArrayList<Integer> pictures;
    private CircleIndicator circle_indicator;
    private NeumorphCardView mNeumorphCardView;
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
        circle_indicator = view.findViewById(R.id.circle_indicator);
        mNeumorphCardView = view.findViewById(R.id.card1);
        mNeumorphCardView.setOnClickListener(this);

        adapter = new PagerAdapter_Picture(pictures, getContext());

        viewPager_school_picture.setAdapter(adapter);
        circle_indicator.setViewPager(viewPager_school_picture);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card1:
                mNeumorphCardView.setShapeType(1);
                break;
        }
    }
}
