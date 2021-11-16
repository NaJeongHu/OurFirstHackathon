package com.voda.ourfirsthackathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;


public class PagerAdapter_Picture extends PagerAdapter {

    private List<Integer> pictures;
    private LayoutInflater layoutInflater;
    private Context context;
    private int ClickedPosition = 0;

    public int getClickedPosition() {
        return ClickedPosition;
    }

    public void setClickedPosition(int clickedPosition) {
        ClickedPosition = clickedPosition;
    }


    public PagerAdapter_Picture() {

    }

    public PagerAdapter_Picture(List<Integer> mPictures, Context context) {
        this.pictures = mPictures;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pictures.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_picture, container, false);

        ImageView imageView;
        imageView = view.findViewById(R.id.iv_picture_item_picture);
        imageView.setBackgroundResource(pictures.get(position));

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
