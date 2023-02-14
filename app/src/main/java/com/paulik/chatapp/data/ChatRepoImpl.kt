package com.paulik.chatapp.data

import com.paulik.chatapp.domain.entity.ChatEntity
import com.paulik.chatapp.domain.repo.ChatRepo

class ChatRepoImpl : ChatRepo {

    val chat = ChatEntity(
        "10",
        listOf("12"),
        null
    )

    override fun createChat(userId: String) {
        //TODO("Not yet implemented")
    }

    override fun getChat(userId: String): ChatEntity {
        return chat
    }
}