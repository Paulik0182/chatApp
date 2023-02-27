package com.paulik.chatapp.data

import com.paulik.chatapp.domain.entity.ChatEntity
import com.paulik.chatapp.domain.repo.ChatRepo

class ChatRepoImpl : ChatRepo {

    private val data: MutableList<ChatEntity> = mutableListOf(
        ChatEntity(
            "10",
            listOf("12"),
            null
        ),
        ChatEntity(
            "11",
            listOf("1"),
            null
        ),
        ChatEntity(
            "25",
            listOf("15"),
            null
        )
    )

    override fun createChat(userId: String) {
        //TODO("Not yet implemented")
    }

    override fun getChat(): List<ChatEntity> {
        return ArrayList(data)
    }
}