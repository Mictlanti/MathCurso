package com.horizon.matemticascurso.repository

import com.horizon.matemticascurso.module.TopicData
import com.horizon.matemticascurso.database.MathDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MathRepository @Inject constructor(private val mathDatabaseDao: MathDatabaseDao) {

    fun getAllFavorites() : Flow<List<TopicData>> = mathDatabaseDao.getAllFavorites().flowOn(Dispatchers.IO).conflate()

    fun getFavoritesById(id: Long) : Flow<TopicData> = mathDatabaseDao.getFavoriteById(id).flowOn(Dispatchers.IO).conflate()

    suspend fun insert(math : TopicData) = mathDatabaseDao.insert(math)

    suspend fun update(math: TopicData) = mathDatabaseDao.update(math)

    suspend fun delete(math: TopicData) = mathDatabaseDao.delete(math)

}