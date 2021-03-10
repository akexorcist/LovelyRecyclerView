package com.akexorcist.lovelyrecyclerview.network.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Food(
    @SerializedName("order_name")
    val orderName: String,
    val amount: Int,
    val price: Int,
) : Parcelable
