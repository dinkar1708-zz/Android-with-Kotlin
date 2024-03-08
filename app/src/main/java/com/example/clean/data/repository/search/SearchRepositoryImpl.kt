package com.example.clean.data.repository.search

import com.example.clean.data.source.local.dao.UserDao
import com.example.clean.data.source.network.NetworkDataSource
import com.example.clean.data.source.network.toExternal
import com.example.clean.data.source.network.toLocal
import com.example.clean.di.DefaultDispatcher
import com.example.clean.domain.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: UserDao,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher
) : SearchRepository {

    override suspend fun searchUsers(): Flow<List<User>> {
//        if (localDataSource.isEmpty()) {
        refreshUsers()
//        }

        return localDataSource.observeAll()
            .map { entities ->
                withContext(dispatcher) {
                    entities.toExternal()
                }
            }
    }

    override suspend fun refreshUsers() {
        withContext(dispatcher) {
            runCatching { networkDataSource.searchUserList() }
                .onSuccess { localDataSource.upsertAll(it.users.toLocal()) }
                .onFailure {
                    Timber.e(it, "Error updating local data from remote source")
                }
        }
    }
}
