package com.akexorcist.lovelyrecyclerview.util

import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail

object OrderDetailConverter {
    fun createUserDetail(name: String): OrderDetailItem.UserDetail {
        return OrderDetailItem.UserDetail(
            name = name
        )
    }

    fun createTitle(title: String): OrderDetailItem.Title {
        return OrderDetailItem.Title(
            title = title
        )
    }

    fun createTotal(orderDetail: OrderDetail, currency: String): OrderDetailItem.Total {
        val total = (orderDetail.foodList?.sumOf { it.price } ?: 0) +
                (orderDetail.bookList?.sumOf { it.price } ?: 0) +
                (orderDetail.musicList?.sumOf { it.price } ?: 0)
        return OrderDetailItem.Total(
            totalPrice = "$total$currency",
        )
    }

    fun createNotice(): OrderDetailItem.Notice {
        return OrderDetailItem.Notice
    }

    fun createButton(): OrderDetailItem.Button {
        return OrderDetailItem.Button
    }

    fun createEmpty(): OrderDetailItem.Empty {
        return OrderDetailItem.Empty
    }

    fun createNoOrder(): OrderDetailItem.NoOrder {
        return OrderDetailItem.NoOrder
    }

    fun createSection(title: String, titleColor: Int): OrderDetailItem.Section {
        return OrderDetailItem.Section(
            section = title,
            backgroundColor = titleColor
        )
    }

    fun createOrder(name: String, detail: String, price: String): OrderDetailItem.Order {
        return OrderDetailItem.Order(
            name = name,
            detail = detail,
            price = price
        )
    }

    fun createSectionAndOrder(
        orderDetail: OrderDetail,
        foodTitle: String,
        bookTitle: String,
        musicTitle: String,
        currency: String,
        foodTitleColor: Int,
        bookTitleColor: Int,
        musicTitleColor: Int
    ): List<OrderDetailItem> {
        return mutableListOf<OrderDetailItem>().apply {
            // Food
            if (!orderDetail.foodList.isNullOrEmpty()) {
                add(createSection(foodTitle, foodTitleColor))
                addAll(
                    orderDetail.foodList.map { food ->
                        OrderDetailItem.Order(
                            name = food.orderName,
                            detail = "x${food.amount}",
                            price = "${food.price}$currency"
                        )
                    })
            }

            // Book
            if (!orderDetail.bookList.isNullOrEmpty()) {
                add(createSection(bookTitle, bookTitleColor))
                addAll(
                    orderDetail.bookList.map { book ->
                        OrderDetailItem.Order(
                            name = book.bookName,
                            detail = book.author,
                            price = "${book.price}$currency"
                        )
                    })
            }

            // Music
            if (!orderDetail.musicList.isNullOrEmpty()) {
                add(createSection(musicTitle, musicTitleColor))
                addAll(
                    orderDetail.musicList.map { music ->
                        OrderDetailItem.Order(
                            name = music.album,
                            detail = music.artist,
                            price = "${music.price}$currency"
                        )
                    })
            }
        }
    }

    fun createSummary(
        orderDetail: OrderDetail,
        foodTitle: String,
        bookTitle: String,
        musicTitle: String,
        currency: String
    ): List<OrderDetailItem.Summary> {
        return mutableListOf<OrderDetailItem.Summary>().apply {
            // Food
            if (!orderDetail.foodList.isNullOrEmpty()) {
                add(
                    OrderDetailItem.Summary(
                        name = foodTitle,
                        price = "${orderDetail.foodList.sumOf { it.price }}$currency"
                    )
                )
            }

            // Book
            if (!orderDetail.bookList.isNullOrEmpty()) {
                add(
                    OrderDetailItem.Summary(
                        name = bookTitle,
                        price = "${orderDetail.bookList.sumOf { it.price }}$currency"
                    )
                )
            }

            // Music
            if (!orderDetail.musicList.isNullOrEmpty()) {
                add(
                    OrderDetailItem.Summary(
                        name = musicTitle,
                        price = "${orderDetail.musicList.sumOf { it.price }}$currency"
                    )
                )
            }
        }
    }
}
