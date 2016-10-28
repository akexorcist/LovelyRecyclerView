package com.akexorcist.lovelyrecyclerview.adapter.model;

import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailType;

/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class TotalItem extends BaseOrderDetailItem {
    private String totalPrice;

    public TotalItem() {
        super(OrderDetailType.TYPE_TOTAL);
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
