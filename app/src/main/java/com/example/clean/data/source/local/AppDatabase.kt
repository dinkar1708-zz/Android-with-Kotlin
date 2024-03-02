package com.example.clean.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clean.data.source.local.dao.UserDao
import com.example.clean.data.source.local.dao.UserRepoDao
import com.example.clean.data.source.local.entity.UserEntity
import com.example.clean.data.source.local.entity.UserRepoEntity

@Database(
    entities = [UserRepoEntity::class, UserEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun userRepoDao(): UserRepoDao
}