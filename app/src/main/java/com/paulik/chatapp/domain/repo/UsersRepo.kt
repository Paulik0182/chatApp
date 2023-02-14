package com.paulik.chatapp.domain.repo

import com.paulik.chatapp.domain.entity.UserEntity

interface UsersRepo {

    fun addUser(userEntity: UserEntity)
    fun getUsers(): List<UserEntity>
}