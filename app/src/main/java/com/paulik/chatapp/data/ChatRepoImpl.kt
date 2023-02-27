package com.paulik.chatapp.data

import com.paulik.chatapp.domain.entity.ChatEntity
import com.paulik.chatapp.domain.repo.ChatRepo

class ChatRepoImpl : ChatRepo {

    private val data: MutableList<ChatEntity> = mutableListOf(
        ChatEntity(
            "10",
            listOf("1", "2"),
            null
        ),
        ChatEntity(
            "25",
            listOf("1", "3"),
            null
        ),
        ChatEntity(
            "30",
            listOf("1", "4"),
            null
        )
    )

    override fun createChat(userId: String) {
        //TODO("Not yet implemented")
    }

    override fun getChats(): List<ChatEntity> {
        return ArrayList(data)
    }

    override fun getChat(id: String): ChatEntity {
        return getChats().first { it.id == id }
    }
}