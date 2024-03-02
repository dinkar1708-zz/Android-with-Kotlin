package com.example.clean.di

import android.content.Context
import com.example.clean.data.source.network.AssetDataSourceImpl
import com.example.clean.data.source.network.NetworkDataSource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkDataSourceModule {

    private val moshi: Moshi by lazy { Moshi.Builder().add(KotlinJsonAdapterFactory()).build() }

    @Singleton
    @Provides
    fun provideNetworkDataSource(@ApplicationContext context: Context): NetworkDataSource {
        // TODO replace with network data source
        return AssetDataSourceImpl(context = context, moshi = moshi, dispatcher = Dispatchers.IO)
    }
}