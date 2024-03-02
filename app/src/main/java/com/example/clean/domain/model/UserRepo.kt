package com.example.clean.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserRepo(
    val id: Long = 0,
    val name: String = "",
    val login: String = "",
    val type: String = "",
    val url: String = "",
    val avatarUrl: String = "",
    val description: String = ""
)