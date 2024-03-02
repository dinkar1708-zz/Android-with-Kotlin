package com.example.clean.data.source.network

import com.example.clean.data.source.network.model.UserRepoResponse
import com.example.clean.data.source.network.model.UsersListResponse

interface NetworkDataSource {
    suspend fun searchUserList(): UsersListResponse
    suspend fun refreshUserRepositories(login: String): UserRepoResponse
}