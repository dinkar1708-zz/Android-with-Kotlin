package com.example.clean.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: Long = 0,
    val login: String = "",
    val type: String = "",
    val url: String = "",
    @Json(name = "avatar_url")
    val avatarUrl: String = "",
    val score: Double = 0.0
)
