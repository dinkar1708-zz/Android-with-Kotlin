package com.example.clean.domain.usecase

import com.example.clean.data.repository.user.UserRepository
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SearchRepositoryUseCaseTest {
    private val mockRepository: UserRepository = mockk()
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var userRepositoryUseCase: UserRepositoryUseCase

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        userRepositoryUseCase = UserRepositoryUseCase(mockRepository)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun searchUsers() {
    }
}