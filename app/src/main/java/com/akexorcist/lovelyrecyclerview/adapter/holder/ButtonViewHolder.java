package com.akexorcist.lovelyrecyclerview.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.akexorcist.lovelyrecyclerview.R;


/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class ButtonViewHolder extends RecyclerView.ViewHolder {
    public Button btnPositive;
    public Button btnNegative;

    public ButtonViewHolder(View itemView) {
        super(itemView);
        btnPositive = (Button) itemView.findViewById(R.id.btn_positive);
        btnNegative = (Button) itemView.findViewById(R.id.btn_negative);
    }
}
