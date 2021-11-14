package com.voda.ourfirsthackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ReservationActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView mRecyclerView;
    private LinearLayoutManager mManager;
    private ImageView mBackButton;
    private ReservationRecyclerAdapter adapter;
    private ArrayList<AvailableSchool> PermittedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        init();
        addItemTouchListenerOnRecyclerView();
        connectToAdapter();
//        getDataFromServer();
    }


    // when user touch item
    private void addItemTouchListenerOnRecyclerView() {
        mRecyclerView.addOnItemTouchListener(new RecyclerViewOnItemClickListener(getApplicationContext(), mRecyclerView,
                new RecyclerViewOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        // todo : bottom sheet layout 필요

                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PermittedList.get(position).getName());
                        bottomSheetDialog.show(getSupportFragmentManager(), "bottomsheet");

//                        Intent intent = new Intent(getApplicationContext(), HouseInfoActivity.class);
//                        intent.putExtra("idx", PermittedList.get(position).getIdx());
//                        startActivity(intent);
//                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    }

                    @Override
                    public void onItemLongClick(View v, int position) {

                    }
                }));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_list_back:
                onBackPressed();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
        }
    }

    private void init() {
        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.main_mauve));
        mManager = new LinearLayoutManager(ReservationActivity.this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView = findViewById(R.id.recyclerview_list);
        mBackButton = findViewById(R.id.btn_list_back);

        mRecyclerView.setLayoutManager(mManager);
        mBackButton.setOnClickListener(this);

        PermittedList = new ArrayList<AvailableSchool>();
        for(int i =0;i<10;i++) {
            AvailableSchool availableSchool = new AvailableSchool(1000, "산격초","대구 북구","httphttphttp");
            if (availableSchool != null && PermittedList != null) {
                PermittedList.add(availableSchool);
            }
        }
    }

    private void connectToAdapter() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (PermittedList != null && PermittedList.isEmpty() == false || PermittedList.size() != 0) {
                            adapter = new ReservationRecyclerAdapter(getApplicationContext(), PermittedList);
                            mRecyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        } else if (PermittedList.size() == 0) {
                        }
//                        base_progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }
}