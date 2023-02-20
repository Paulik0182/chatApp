package com.paulik.chatapp.data

import com.paulik.chatapp.domain.entity.UserEntity
import com.paulik.chatapp.domain.repo.UsersRepo

class UserRepoImpl : UsersRepo {
    private val user = listOf(
        UserEntity(
            "12",
            "Pol",
            "https://avatarko.ru/img/kartinka/11/Batman_10072.jpg" // todo
        ),
        UserEntity(
            "13",
            "Mark",
            "https://avatarko.ru/img/kartinka/13/zhivotnye_tigr_12814.jpg" // todo
        ),
        UserEntity(
            "25",
            "Jon",
            "https://avatarko.ru/img/kartinka/8/sobaka_prikol_7066.jpg" // todo
        )
    )

    override fun addUser(userEntity: UserEntity) {
        //TODO("Not yet implemented")
    }

    override fun getUsers(): List<UserEntity> {
        return ArrayList(user)
    }
}