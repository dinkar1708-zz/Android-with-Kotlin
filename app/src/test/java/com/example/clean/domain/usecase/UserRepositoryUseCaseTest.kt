package com.example.clean.domain.usecase

import com.example.clean.data.repository.search.SearchRepository
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UserRepositoryUseCaseTest {
    private val mockRepository: SearchRepository = mockk()
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var searchRepositoryUseCase: SearchRepositoryUseCase

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        searchRepositoryUseCase = SearchRepositoryUseCase(mockRepository)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun searchUserRepositories() {
    }
}