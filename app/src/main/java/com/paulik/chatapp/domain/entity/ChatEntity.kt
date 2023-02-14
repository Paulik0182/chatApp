package com.paulik.chatapp.domain.entity

data class ChatEntity(
    val id: String,
    val usersIds: List<String>,
    val lastMessage: MessageEntity?
)