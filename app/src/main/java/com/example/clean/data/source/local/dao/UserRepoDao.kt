package com.example.clean.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.clean.data.source.local.entity.UserRepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserRepoDao {

    @Query("SELECT * FROM UserRepoEntity")
    fun observeAll(): Flow<List<UserRepoEntity>>

    @Query("SELECT * FROM UserRepoEntity WHERE login = :login")
    fun observeAllForUser(login: String): Flow<List<UserRepoEntity>>

    @Upsert
    suspend fun upsertAll(userRepos: List<UserRepoEntity>)

    // query for empty result
    @Query("SELECT (SELECT COUNT(*) FROM UserRepoEntity WHERE login = :login) == 0")
    suspend fun isEmpty(login: String): Boolean

    @Query("DELETE FROM UserRepoEntity")
    suspend fun deleteAll()

}