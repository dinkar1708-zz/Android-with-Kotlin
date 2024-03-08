package com.example.clean.data.repository.user

import com.example.clean.data.source.local.dao.UserRepoDao
import com.example.clean.data.source.network.NetworkDataSource
import com.example.clean.domain.model.UserRepo
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

@OptIn(ExperimentalCoroutinesApi::class)
class UserRepositoryImplTest {

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
    private val mockNetworkDataSource: NetworkDataSource = mockk()
    private val mockLocalDataSource: UserRepoDao = mockk()
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var repository: UserRepositoryImpl

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        repository = UserRepositoryImpl(
            networkDataSource = mockNetworkDataSource,
            localDataSource = mockLocalDataSource,
            dispatcher = testDispatcher
        )
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

}