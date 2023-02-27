package com.paulik.chatapp.domain.repo

import com.paulik.chatapp.domain.entity.ChatEntity

interface ChatRepo {

    fun createChat(userId: String)
    fun getChats(): List<ChatEntity>
    fun getChat(id: String): ChatEntity
}