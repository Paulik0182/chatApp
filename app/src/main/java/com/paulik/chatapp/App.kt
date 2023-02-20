package com.paulik.chatapp

import android.app.Application
import com.paulik.chatapp.data.ChatRepoImpl
import com.paulik.chatapp.data.MessageRepoImpl
import com.paulik.chatapp.data.UserRepoImpl
import com.paulik.chatapp.domain.repo.ChatRepo
import com.paulik.chatapp.domain.repo.MessageRepo
import com.paulik.chatapp.domain.repo.UsersRepo

class App : Application() {

    val chatRepo: ChatRepo by lazy {
        ChatRepoImpl()
    }

    val messageRepo: MessageRepo by lazy {
        MessageRepoImpl()
    }

    val usersRepo: UsersRepo by lazy {
        UserRepoImpl()
    }

}