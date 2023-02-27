package com.paulik.chatapp.domain.repo

import com.paulik.chatapp.domain.entity.MessageEntity
import io.reactivex.rxjava3.core.Observable

interface MessageRepo {

    fun sendMessage(chatId: String, text: String)
    fun markMessageAsViewed(messageId: String)
    fun getMessages(chatId: String): List<MessageEntity>

    fun getMessageUpdates(chatId: String): Observable<List<MessageEntity>>
}