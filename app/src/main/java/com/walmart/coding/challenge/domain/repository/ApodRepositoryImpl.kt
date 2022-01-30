package com.walmart.coding.challenge.domain.repository

import com.walmart.coding.challenge.api.ApodService
import com.walmart.coding.challenge.domain.dao.ApodDao
import com.walmart.coding.challenge.domain.util.Resource
import com.walmart.coding.challenge.domain.util.networkBoundResource
import com.walmart.coding.challenge.model.ApodEntity
import com.walmart.coding.challenge.domain.repository.ApodRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ApodRepositoryImpl @Inject constructor(
    private val appDao: ApodDao,
    private val apodService: ApodService
) :
    ApodRepository {

    override fun getLatestApods(
        isRefresh: Boolean,
        param: Map<String, String>,
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ): Flow<Resource<List<ApodEntity>>> =
        networkBoundResource(
            loadFromDb = {
                appDao.getAll()
            },
            createCall = {
                apodService.getApodList(param)
            },
            saveToDb = { entities ->
                appDao.deleteAll()
                appDao.saveEntries(entities)

            },
            shouldFetch = {
                isRefresh
            },
            onCallSuccess = onSuccess,
            onCallFailed = onError
        )
}