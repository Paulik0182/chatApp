package com.paulik.chatapp.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MessageEntity(

    @SerializedName("id")
    val id: String,

    @SerializedName("text")
    val text: String,

    @SerializedName("author_id")
    val authorId: String,

    @SerializedName("time")
    val time: Long,

    @SerializedName("chat_id")
    val chatId: String,

    @SerializedName("status")
    val status: MessageStatus,

    @SerializedName("mine")
    val mine: Boolean

) : Parcelable

enum class MessageStatus {
    LOADING, SHIPPED, VIEWED, ERROR
}