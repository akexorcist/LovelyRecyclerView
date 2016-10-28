package com.akexorcist.lovelyrecyclerview.adapter.model;

import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailType;

/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class UserDetailItem extends BaseOrderDetailItem {
    private String name;

    public UserDetailItem() {
        super(OrderDetailType.TYPE_USER_DETAIL);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
