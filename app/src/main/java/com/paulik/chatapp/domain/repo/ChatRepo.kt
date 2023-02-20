package com.paulik.chatapp.domain.repo

import com.paulik.chatapp.domain.entity.ChatEntity

interface ChatRepo {

    fun createChat(userId: String)
    fun getChat(): List<ChatEntity>
}