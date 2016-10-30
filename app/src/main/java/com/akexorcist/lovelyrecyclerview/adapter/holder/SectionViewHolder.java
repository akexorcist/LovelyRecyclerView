package com.akexorcist.lovelyrecyclerview.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.akexorcist.lovelyrecyclerview.R;


/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class SectionViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout layoutSectionContainer;
    public TextView tvSection;

    public SectionViewHolder(View itemView) {
        super(itemView);
        layoutSectionContainer = (LinearLayout) itemView.findViewById(R.id.layout_section_container);
        tvSection = (TextView) itemView.findViewById(R.id.tv_section);
    }
}
