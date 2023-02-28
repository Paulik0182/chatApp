package com.paulik.chatapp.domain.entity

data class ChatViewEntity(
    val chatId: String,
    val name: String,
    val text: String?,
    val time: Long?,
    val photoUrl: String?
)
