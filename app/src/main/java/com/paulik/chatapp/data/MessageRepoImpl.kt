package com.paulik.chatapp.data

import com.paulik.chatapp.domain.entity.MessageEntity
import com.paulik.chatapp.domain.entity.MessageStatus
import com.paulik.chatapp.domain.repo.MessageRepo
import io.reactivex.rxjava3.core.Observable
import java.util.*

class MessageRepoImpl : MessageRepo {

    private val messages: MutableList<MessageEntity> = mutableListOf(
        MessageEntity(
            "20",
            "Привет",
            "12",
            Calendar.getInstance().timeInMillis,
            "10",
            MessageStatus.LOADING,
            false
        )
    )

    override fun sendMessage(chatId: String, text: String) {
        messages.add(
            MessageEntity(
                UUID.randomUUID().toString(),
                text,
                "12",
                Calendar.getInstance().timeInMillis,
                chatId,
                MessageStatus.LOADING,
                true
            )
        )
    }

    override fun markMessageAsViewed(messageId: String) {
        TODO("Not yet implemented")
    }

    override fun getMessages(chatId: String): List<MessageEntity> {
        return messages
    }

    override fun getMessageUpdates(): Observable<MessageEntity> {
        TODO("Not yet implemented")
    }
}