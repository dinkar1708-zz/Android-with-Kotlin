package com.example.clean.data.repository.user

import android.util.Log
import com.example.clean.data.source.local.dao.UserRepoDao
import com.example.clean.data.source.network.NetworkDataSource
import com.example.clean.data.source.network.toExternal
import com.example.clean.data.source.network.toLocal
import com.example.clean.di.DefaultDispatcher
import com.example.clean.domain.model.UserRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: UserRepoDao,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher
) : UserRepository {

    override suspend fun searchUserRepositories(login: String): Flow<List<UserRepo>> {
        // TODO add more case here read from api etc
        // save to local if empty
//        if (localDataSource.isEmpty(id)) // comment to test load always
            refreshUserRepositories(login)
        // return data
        return localDataSource.observeAll().map { repositories ->
            withContext(dispatcher) {
                Log.d("dppppp", "searchUserRepositories... id $login .$repositories")
                repositories.toExternal()
            }
        }
    }

    override suspend fun refreshUserRepositories(login: String) {
        Timber.d("refreshUserRepositories....$login")
        withContext(dispatcher) {
            runCatching {
                // download data
                networkDataSource.refreshUserRepositories(login)
            }
                .onSuccess {
                    val a = it.userRepositories.toLocal()
                    Log.d("dppppp", "Got save data $a")
                    localDataSource.upsertAll(it.userRepositories.toLocal())
                }
                .onFailure {
                    error -> Log.d("dppppp", "Error refreshing in the database $error")
                    error.printStackTrace()

                }
        }
    }
}