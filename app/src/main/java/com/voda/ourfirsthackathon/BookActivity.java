package com.voda.ourfirsthackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class BookActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView cardview_dobook, detail_place_1, detail_place_2, detail_place_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.main_mauve));

        cardview_dobook = findViewById(R.id.cardview_dobook);
        cardview_dobook.setOnClickListener(this);

        detail_place_1 = findViewById(R.id.detail_place_1);
        detail_place_2 = findViewById(R.id.detail_place_2);
        detail_place_3 = findViewById(R.id.detail_place_3);

        detail_place_1.setOnClickListener(this);
        detail_place_2.setOnClickListener(this);
        detail_place_3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_place_1:
            case R.id.detail_place_2:
            case R.id.detail_place_3:
                // todo : bottomsheet
                BottomSheetDialogForBook bottomSheetDialog = new BottomSheetDialogForBook("PermittedList.get(position).getName()");
                bottomSheetDialog.show(getSupportFragmentManager(), "bottomsheet");

                break;
        }

    }
}