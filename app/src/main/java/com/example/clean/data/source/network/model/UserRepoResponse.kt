package com.example.clean.data.source.network.model

import com.example.clean.domain.model.UserRepo
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserRepoResponse(
    val userRepositories: List<UserRepo>
)