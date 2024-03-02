package com.example.clean.di

import android.content.Context
import androidx.room.Room
import com.example.clean.data.source.local.AppDatabase
import com.example.clean.data.source.local.dao.UserDao
import com.example.clean.data.source.local.dao.UserRepoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {
    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_db.db",
        ).build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

    @Provides
    fun provideUserRepoDao(database: AppDatabase): UserRepoDao = database.userRepoDao()
}