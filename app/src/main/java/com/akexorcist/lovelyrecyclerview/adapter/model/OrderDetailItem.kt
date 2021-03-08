package com.akexorcist.lovelyrecyclerview.adapter.model

import android.os.Parcelable
import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailType
import kotlinx.parcelize.Parcelize

sealed class OrderDetailItem(val type: Int) : Parcelable {
    @Parcelize
    data class UserDetail(
        val name: String
    ) : OrderDetailItem(OrderDetailType.TYPE_USER_DETAIL)

    @Parcelize
    data class Title(
        val title: String
    ) : OrderDetailItem(OrderDetailType.TYPE_TITLE)

    @Parcelize
    data class Section(
        val section: String,
        val backgroundColor: Int
    ) : OrderDetailItem(OrderDetailType.TYPE_SECTION)

    @Parcelize
    data class Order(
        val name: String,
        val detail: String,
        val price: String
    ) : OrderDetailItem(OrderDetailType.TYPE_ORDER)

    @Parcelize
    data class Summary(
        val name: String,
        val price: String
    ) : OrderDetailItem(OrderDetailType.TYPE_SUMMARY)

    @Parcelize
    data class Total(
        val totalPrice: String
    ) : OrderDetailItem(OrderDetailType.TYPE_TOTAL)

    @Parcelize
    object Notice : OrderDetailItem(OrderDetailType.TYPE_NOTICE)

    @Parcelize
    object Button : OrderDetailItem(OrderDetailType.TYPE_BUTTON)

    @Parcelize
    object Empty : OrderDetailItem(OrderDetailType.TYPE_EMPTY)

    @Parcelize
    object NoOrder : OrderDetailItem(OrderDetailType.TYPE_NO_ORDER)
}
