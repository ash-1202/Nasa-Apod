package com.walmart.coding.challenge.domain.repository

import com.walmart.coding.challenge.domain.util.Resource
import com.walmart.coding.challenge.model.ApodEntity
import kotlinx.coroutines.flow.Flow

interface ApodRepository {
    fun getLatestApods(
        isRefresh : Boolean,
        param : Map<String, String>,
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ): Flow<Resource<List<ApodEntity>>>
}