package com.example.clean.ui.features.userrepository

import com.example.clean.domain.model.User
import com.example.clean.domain.model.UserRepo

data class UserRepoViewState(
    val selectedUser: User = User(),
    val repositories: List<UserRepo> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)
