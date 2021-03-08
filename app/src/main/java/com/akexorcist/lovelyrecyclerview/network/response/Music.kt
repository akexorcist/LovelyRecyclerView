package com.akexorcist.lovelyrecyclerview.network.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Music(
    val artist: String,
    val album: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val track: Int,
    val price: Int
) : Parcelable
