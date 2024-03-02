package com.example.clean.ui.features.users

import com.example.clean.domain.model.User

data class UsersListState(
    val userList: List<User> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)
