package com.akexorcist.lovelyrecyclerview.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.akexorcist.lovelyrecyclerview.R;


/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class SummaryViewHolder extends RecyclerView.ViewHolder {
    public TextView tvSummaryName;
    public TextView tvSummaryPrice;

    public SummaryViewHolder(View itemView) {
        super(itemView);
        tvSummaryName = (TextView) itemView.findViewById(R.id.tv_summary_name);
        tvSummaryPrice = (TextView) itemView.findViewById(R.id.tv_summary_price);
    }
}
