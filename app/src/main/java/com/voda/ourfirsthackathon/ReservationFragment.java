package com.voda.ourfirsthackathon;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ReservationFragment extends Fragment {

    private ImageView iv_main_gosearch;

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

        return view;
    }
}