package com.walmart.coding.challenge.di

import com.walmart.coding.challenge.api.ApodService
import com.walmart.coding.challenge.domain.dao.ApodDao
import com.walmart.coding.challenge.domain.repository.ApodRepository
import com.walmart.coding.challenge.domain.repository.ApodRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideApodRepository(appDao: ApodDao, apodService: ApodService): ApodRepository =
        ApodRepositoryImpl(appDao, apodService)
}