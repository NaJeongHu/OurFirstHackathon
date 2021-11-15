package com.voda.ourfirsthackathon;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

class ReservationRecyclerAdapter extends RecyclerView.Adapter<ReservationRecyclerAdapter.CustomViewHolder> {

    private ArrayList<AvailableSchool> mList;
    private LayoutInflater mInflate;
    private Context context;

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView name, location, price;
        private ImageView iv_item_list_title;
        private ImageView iv_item_list_back;

        public CustomViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.tv_item_list_name);
            this.location = view.findViewById(R.id.tv_item_list_info);
            this.price = view.findViewById(R.id.tv_item_list_price);
            this.iv_item_list_title = view.findViewById(R.id.iv_item_list_title);
            this.iv_item_list_back = view.findViewById(R.id.iv_item_list_back);
        }
    }

    public ReservationRecyclerAdapter(Context context, ArrayList<AvailableSchool> items) {
        this.mList = items;
        this.mInflate = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.item_available_school, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.name.setText(mList.get(position).getName());
        holder.location.setText(mList.get(position).getLocation());
        holder.price.setText("$" + String.valueOf(mList.get(position).getPrice()));
        Glide.with(context).load(mList.get(position).getImageurl()).into(holder.iv_item_list_title);
        holder.iv_item_list_back.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        holder.iv_item_list_back.setRotationY(180);
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }


}
