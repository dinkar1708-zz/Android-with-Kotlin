package com.example.clean.data.source.network

import com.example.clean.data.source.local.entity.UserEntity
import com.example.clean.data.source.local.entity.UserRepoEntity
import com.example.clean.domain.model.User
import com.example.clean.domain.model.UserRepo

fun User.toLocal() = UserEntity(
    id = id,
    login = login,
    type = type,
    url = url,
    avatarUrl = avatarUrl,
    score = score
)

fun List<User>.toLocal() = map(User::toLocal)

fun UserRepo.toLocal() = UserRepoEntity(
    id = id,
    name = name,
    login = login,
    type = type,
    url = url,
    avatarUrl = avatarUrl,
    description = description
)

@JvmName("externalToLocal")
fun List<UserRepo>.toLocal() = map(UserRepo::toLocal)

fun UserEntity.toExternal() = User(
    id = id,
    login = login,
    type = type,
    url = url,
    avatarUrl = avatarUrl,
    score = score
)


@JvmName("localToExternal")
fun List<UserEntity>.toExternal() = map(UserEntity::toExternal)

fun UserRepoEntity.toExternal() = UserRepo(
    id = id,
    login = login,
    type = type,
    url = url,
    avatarUrl = avatarUrl,
    description = description
)

fun List<UserRepoEntity>.toExternal() = map(UserRepoEntity::toExternal)