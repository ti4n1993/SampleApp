package com.ti4n.sampleapp.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BaseDao<T> {

    fun queryAll(): Flow<List<T>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg item: T)

    @Update
    suspend fun update(vararg item: T)

    @Delete
    suspend fun delete(item: T)
}