package com.example.clean.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.clean.data.source.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun observeAll(): Flow<List<UserEntity>>

    @Upsert
    suspend fun upsertAll(users: List<UserEntity>)

    @Query("DELETE FROM user")
    suspend fun deleteAll()

    @Query("SELECT NOT EXISTS(SELECT 1 FROM user LIMIT 1)")
    suspend fun isEmpty(): Boolean
}
