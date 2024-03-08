package com.example.clean.ui.features.userrepository

import com.example.clean.domain.model.User
import com.example.clean.domain.model.UserRepo
import com.example.clean.domain.usecase.UserRepositoryUseCase
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UserRepoScreenViewModelTest {
    private val user = User(
        id = 1,
        login = "dinkar1708",
        type = "User",
        avatarUrl = "uavatarUrlavatarUrlavatarUrlavatarUrlrl",
    )

    private val repositoriesTestData = mutableListOf(
        UserRepo(
            id = 1,
            login = "dinkar1708",
            type = "User",
            url = "",
            avatarUrl = "",
        ),
        UserRepo(
            id = 2,
            login = "dinkar1708",
            type = "User",
            url = "",
            avatarUrl = "",
            description = "sdlfjsdf dfjlkdj f"
        )
    )

    private val mockUserRepositoryUseCase: UserRepositoryUseCase = mockk()
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: UserRepoScreenViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = UserRepoScreenViewModel(mockUserRepositoryUseCase, testDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getUserRepositories() {
    }
}