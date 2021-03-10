package com.akexorcist.lovelyrecyclerview.network

import android.os.Handler
import android.os.Looper
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail
import com.google.gson.Gson
import kotlin.random.Random

object FakeNetwork {
    fun getFakeOrderDetail(callback: (orderDetail: OrderDetail) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            callback.invoke(createFakeOrderDetail())
        }, 2000)
    }

    private fun createFakeOrderDetail(): OrderDetail {
        val fakeJsonList = arrayOf(
            "{\"food_list\":[{\"order_name\":\"Chicken\",\"amount\":2,\"price\":400},{\"order_name\":\"Egg\",\"amount\":24,\"price\":120}],\"book_list\":[{\"ISBN\":\"9780804139038\",\"book_name\":\"The Martian: A Novel\",\"author\":\"Andy Weir\",\"publish_date\":\"11 February 2014\",\"publication\":\"Broadway Books\",\"price\":314,\"pages\":384},{\"ISBN\":\"9781449327972\",\"book_name\":\"Embedded Android: Porting, Extending, and Customizing\",\"author\":\"Karim Yaghmour\",\"publish_date\":\"12 March 2013\",\"publication\":\"O'Reilly Media, Inc.\",\"price\":475,\"pages\":412},{\"ISBN\":\"9780545229937\",\"book_name\":\"The Hunger Games\",\"author\":\"Suzanne Collins\",\"publish_date\":\"1 September 2009\",\"publication\":\"Scholastic Inc.\",\"price\":279,\"pages\":384}],\"music_list\":[{\"artist\":\"Green Day\",\"album\":\"American Idiot\",\"release_date\":\"8 September 2004\",\"track\":9,\"price\":330}]}",
            "{\"food_list\":[],\"book_list\":[],\"music_list\":[]}",
            "{\"food_list\":null,\"book_list\":null,\"music_list\":null}",
            "{ }",
            "",
            "null"
        )
        val index: Int = Random.nextInt(fakeJsonList.size)
        return Gson().fromJson(fakeJsonList[index], OrderDetail::class.java)
    }
}
