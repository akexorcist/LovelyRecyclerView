package com.akexorcist.lovelyrecyclerview.adapter.model;

import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailType;

/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class TitleItem extends BaseOrderDetailItem {
    private String title;

    public TitleItem() {
        super(OrderDetailType.TYPE_TITLE);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
