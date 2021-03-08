package com.akexorcist.lovelyrecyclerview.network.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Book(
    @SerializedName("ISBN")
    val isbn: String,
    @SerializedName("book_name")
    val bookName: String,
    val author: String,
    val publishDate: String,
    val publication: String,
    val price: Int,
    val pages: Int,
) : Parcelable
