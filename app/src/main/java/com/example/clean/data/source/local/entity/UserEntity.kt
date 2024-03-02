package com.example.clean.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Long,
    val login: String,
    val type: String,
    val url: String,
    val avatarUrl: String = "",
    val score: Double,
)