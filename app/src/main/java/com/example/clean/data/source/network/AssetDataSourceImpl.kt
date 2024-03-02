package com.example.clean.data.source.network

import android.content.Context
import com.example.clean.AppConfig
import com.example.clean.data.source.network.model.UserRepoResponse
import com.example.clean.data.source.network.model.UsersListResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonEncodingException
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.FileNotFoundException
import okio.IOException
import okio.buffer
import okio.source

sealed class AssetDataSourceError : Exception() {
    data class MalformedData(val exception: Throwable) : AssetDataSourceError()
    data class FileNotFoundError(val exception: Throwable) : AssetDataSourceError()
    data class Unknown(val exception: Throwable) : AssetDataSourceError()
}

class AssetDataSourceImpl(
    private val context: Context,
    private val moshi: Moshi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : NetworkDataSource {

    override suspend fun searchUserList(): UsersListResponse {
        return parseJsonFromAssets(AppConfig.USERS_LIST_FILE_NAME)
    }

    override suspend fun refreshUserRepositories(login: String): UserRepoResponse {
        val fileName = AppConfig.USER_REPOSITORY_FILE_FORMAT.format(
            AppConfig.USER_REPOSITORY_FILE_NAME_PREFIX,
            login,
            AppConfig.USER_REPOSITORY_FILE_NAME_EXTENSION
        )
        return parseJsonFromAssets(fileName)
    }

    private suspend inline fun <reified T> parseJsonFromAssets(fileName: String): T {
        return withContext(dispatcher) {
            runCatching {
                val adapter: JsonAdapter<T> = moshi.adapter(T::class.java)
                val bufferedSource = context.assets.open(fileName).source().buffer()
                adapter.fromJson(bufferedSource) ?: throw IOException()
            }.getOrElse {
                throw mapToAssetDataSourceError(it)
            }
        }
    }

    private fun mapToAssetDataSourceError(exception: Throwable): AssetDataSourceError {
        return when (exception) {
            is JsonEncodingException -> AssetDataSourceError.MalformedData(exception)
            is FileNotFoundException -> AssetDataSourceError.FileNotFoundError(exception)
            else -> AssetDataSourceError.Unknown(exception)
        }
    }
}
