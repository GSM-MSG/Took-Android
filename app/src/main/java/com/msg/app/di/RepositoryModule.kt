package com.msg.app.di

import com.msg.data.remote.datasource.datasourceImpl.ImageDataSourceImpl
import com.msg.data.repository.ImageRepositoryImpl
import com.msg.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideImageRepository(dataSource: ImageDataSourceImpl): ImageRepository =
        ImageRepositoryImpl(dataSource)
}