package com.akexorcist.lovelyrecyclerview.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.akexorcist.lovelyrecyclerview.R;


/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder {
    public TextView tvOrderName;
    public TextView tvOrderDetail;
    public TextView tvOrderPrice;

    public OrderViewHolder(View itemView) {
        super(itemView);
        tvOrderName = (TextView) itemView.findViewById(R.id.tv_order_name);
        tvOrderDetail = (TextView) itemView.findViewById(R.id.tv_order_detail);
        tvOrderPrice = (TextView) itemView.findViewById(R.id.tv_order_price);
    }
}
