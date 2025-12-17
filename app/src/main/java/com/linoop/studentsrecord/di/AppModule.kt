package com.linoop.studentsrecord.di

import android.content.Context
import androidx.room.Room
import com.linoop.studentsrecord.data.local.AppDataBase
import com.linoop.studentsrecord.data.local.dao.StudentDao
import com.linoop.studentsrecord.data.repository.RepositoryImpl
import com.linoop.studentsrecord.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun roomDatabaseProvider(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "student_db"
        ).build()

    @Provides
    fun studentDaoProvider(appDataBase: AppDataBase): StudentDao = appDataBase.studentDao()
}