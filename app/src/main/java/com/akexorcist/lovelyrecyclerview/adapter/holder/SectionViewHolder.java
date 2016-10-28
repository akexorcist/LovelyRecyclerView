package com.akexorcist.lovelyrecyclerview.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.akexorcist.lovelyrecyclerview.R;


/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class SectionViewHolder extends RecyclerView.ViewHolder {
    public TextView tvSection;

    public SectionViewHolder(View itemView) {
        super(itemView);
        tvSection = (TextView) itemView.findViewById(R.id.tv_section);
    }
}
