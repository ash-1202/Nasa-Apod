package com.walmart.coding.challenge.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.walmart.coding.challenge.domain.dao.ApodDao
import com.walmart.coding.challenge.model.ApodEntity

@Database(entities = [ApodEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun apodListDao(): ApodDao
}