package com.paulik.chatapp.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChatEntity(

    @SerializedName("id")
    val id: String,

    @SerializedName("users_ids")
    val usersIds: List<String>,

    @SerializedName("last_message")
    val lastMessage: MessageEntity?

) : Parcelable