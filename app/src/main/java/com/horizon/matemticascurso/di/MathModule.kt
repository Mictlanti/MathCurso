package com.horizon.matemticascurso.di

import android.content.Context
import androidx.room.Room
import com.horizon.matemticascurso.database.MathDatabase
import com.horizon.matemticascurso.database.MathDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MathModule {

    @Singleton
    @Provides
    fun providesMathDao(mathDatabase: MathDatabase) : MathDatabaseDao {
        return mathDatabase.mathDao()
    }

    @Singleton
    @Provides
    fun providesMathDatabase(@ApplicationContext contex : Context) : MathDatabase {
        return Room.databaseBuilder(
            contex,
            MathDatabase::class.java,
            "math_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

}