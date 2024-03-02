package com.example.clean.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserRepoEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val login: String,
    val type: String,
    val url: String,
    val avatarUrl: String,
    val description: String
)