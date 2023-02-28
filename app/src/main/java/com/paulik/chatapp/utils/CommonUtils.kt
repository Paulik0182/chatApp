package com.paulik.chatapp.utils

import android.content.Context
import com.paulik.chatapp.R
import com.paulik.chatapp.domain.ErrorMessage

fun ErrorMessage.toString(context: Context): String {
    return when (this) {
        ErrorMessage.TEXT_CHAT_MESSAGE -> context.getString(R.string.text_chat_message_error)
    }
}