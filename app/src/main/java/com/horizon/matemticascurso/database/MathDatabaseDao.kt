package com.horizon.matemticascurso.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.horizon.matemticascurso.module.TopicData
import kotlinx.coroutines.flow.Flow

@Dao
interface MathDatabaseDao {

    @Query("SELECT * FROM favorites")
    fun getAllFavorites() : Flow<List<TopicData>>

    @Query("SELECT * FROM favorites WHERE id = :id")
    fun getFavoriteById(id: Long) : Flow<TopicData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(math : TopicData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(math: TopicData)

    @Delete()
    suspend fun delete(math: TopicData)

}