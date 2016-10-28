package com.akexorcist.lovelyrecyclerview.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.akexorcist.lovelyrecyclerview.R;


/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class TitleViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;

    public TitleViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }
}
