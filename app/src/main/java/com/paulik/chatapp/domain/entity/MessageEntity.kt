package com.paulik.chatapp.domain.entity


data class MessageEntity(
    val id: String,
    val text: String,
    val authorId: String,
    val time: Long,
    val chatId: String,
    val status: MessageStatus,
    val mine: Boolean
)

enum class MessageStatus {
    LOADING, SHIPPED, VIEWED, ERROR
}