package com.paulik.chatapp.data

import com.paulik.chatapp.domain.entity.MessageEntity
import com.paulik.chatapp.domain.entity.MessageStatus
import com.paulik.chatapp.domain.interactors.MessageCreatorInteractor
import com.paulik.chatapp.domain.repo.MessageRepo

class MessageCreatorInteractorImpl(
    private val messageRepo: MessageRepo
) : MessageCreatorInteractor {
    override fun create(
        id: String,
        authorId: String,
        chatId: String,
        text: String,
        time: Long?,
        mine: Boolean
    ): MessageEntity {
        val messageEntity = MessageEntity(
            id = id,
            authorId = authorId,
            chatId = chatId,
            text = text,
            time = time!!,
            mine = mine,
            status = MessageStatus.LOADING
        )

        messageRepo.sendMessage(messageEntity.chatId, messageEntity.text)

        return messageEntity
    }
}