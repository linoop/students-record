package com.linoop.studentsrecord.di

import com.linoop.studentsrecord.data.repository.RepositoryImpl
import com.linoop.studentsrecord.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class BinderModule {
    @Binds
    abstract fun bindRepository(impl: RepositoryImpl): Repository
}