package com.paulik.chatapp.domain.interactors

import com.paulik.chatapp.domain.entity.MessageEntity

interface MessageCreatorInteractor {

    fun send(
        id: String,
        authorId: String,
        chatId: String,
        text: String,
        time: Long?,
        mine: Boolean
    ): MessageEntity
}