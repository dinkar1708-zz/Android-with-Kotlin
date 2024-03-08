package com.example.clean.ui.features.users

import com.example.clean.domain.model.User
import com.example.clean.domain.usecase.SearchRepositoryUseCase
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UsersListViewModelTest {

    val usersTestData = listOf(
        User(
            id = 1,
            login = "dinkar1708",
            type = "User",
            avatarUrl = "uavatarUrlavatarUrlavatarUrlavatarUrlrl",
        ), User(
            id = 2,
            login = "dinkar170811",
            type = "User",
            avatarUrl = "avatarUrlavatarUrlavatarUrlavatarUrl",
        )
    )


    private val mockSearchRepositoryUseCase: SearchRepositoryUseCase = mockk()
    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: UsersListViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = UsersListViewModel(mockSearchRepositoryUseCase, testDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getUiState() {
    }
}