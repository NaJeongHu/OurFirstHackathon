package com.voda.ourfirsthackathon;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

public class ReservationFragment extends Fragment implements View.OnClickListener{

    private ImageView iv_main_gosearch;
    private LinearLayout linear_badminton;

    public ReservationFragment() { }

    public static ReservationFragment newInstance() {
        ReservationFragment fragment = new ReservationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);

        iv_main_gosearch = view.findViewById(R.id.iv_main_gosearch);
        iv_main_gosearch.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        linear_badminton = view.findViewById(R.id.linear_badminton);
        linear_badminton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.linear_badminton:
                Intent intent = new Intent(getActivity(), ReservationActivity.class);
                startActivity(intent);
                break;

        }
    }
}