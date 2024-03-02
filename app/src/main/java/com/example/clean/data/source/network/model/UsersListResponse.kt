package com.example.clean.data.source.network.model

import com.example.clean.domain.model.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsersListResponse(
    val users: List<User>
)