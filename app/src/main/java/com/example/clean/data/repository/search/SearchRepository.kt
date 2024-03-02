package com.example.clean.data.repository.search

import com.example.clean.domain.model.User
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun searchUsers(): Flow<List<User>>
    suspend fun refreshUsers()
}