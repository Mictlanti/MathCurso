package com.horizon.matemticascurso.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.horizon.matemticascurso.module.TopicData

@Database(entities = [TopicData::class], version = 1, exportSchema = false)
abstract class MathDatabase : RoomDatabase(){

    abstract fun mathDao() : MathDatabaseDao

}