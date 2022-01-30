package com.walmart.coding.challenge.di

import android.content.Context
import androidx.room.Room
import com.walmart.coding.challenge.domain.dao.ApodDao
import com.walmart.coding.challenge.domain.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "appDatabase.db"
        ).allowMainThreadQueries().build()

    @Provides
    fun provideApodDao(database: AppDatabase): ApodDao =
        database.apodListDao()
}