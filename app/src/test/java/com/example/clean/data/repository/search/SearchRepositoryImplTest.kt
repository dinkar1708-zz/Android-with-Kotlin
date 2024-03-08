package com.example.clean.data.repository.search

import com.example.clean.data.source.local.dao.UserDao
import com.example.clean.data.source.network.NetworkDataSource
import com.example.clean.domain.model.User
import io.mockk.mockk
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SearchRepositoryImplTest {

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

    private val mockNetworkDataSource: NetworkDataSource = mockk()
    private val mockLocalDataSource: UserDao = mockk()
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var repository: SearchRepositoryImpl

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun searchUsers() {
    }

    @Test
    fun refreshUsers() {
    }
}