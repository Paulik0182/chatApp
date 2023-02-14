package com.paulik.chatapp.data

import com.paulik.chatapp.domain.entity.UserEntity
import com.paulik.chatapp.domain.repo.UsersRepo

class UserRepoImpl : UsersRepo {
    val user = UserEntity(
        "12",
        "Pol",
        "kkkkk" // todo
    )

    override fun addUser(userEntity: UserEntity) {
        //TODO("Not yet implemented")
    }

    override fun getUsers(): List<UserEntity> {
        return listOf(user)
    }
}