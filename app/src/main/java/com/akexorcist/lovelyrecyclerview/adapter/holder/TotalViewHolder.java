package com.akexorcist.lovelyrecyclerview.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.akexorcist.lovelyrecyclerview.R;


/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class TotalViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTotalPrice;

    public TotalViewHolder(View itemView) {
        super(itemView);
        tvTotalPrice = (TextView) itemView.findViewById(R.id.tv_total_price);
    }
}
