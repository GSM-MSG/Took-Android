package com.msg.app.di

import com.msg.data.remote.datasource.datasource.BusinessCardDataSource
import com.msg.data.remote.datasource.datasource.ImageDataSource
import com.msg.data.repository.BusinessCardRepositoryImpl
import com.msg.data.repository.ImageRepositoryImpl
import com.msg.domain.repository.BusinessCardRepository
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
    fun provideImageRepository(dataSource: ImageDataSource): ImageRepository =
        ImageRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideBusinessCardRepository(dataSource: BusinessCardDataSource): BusinessCardRepository =
        BusinessCardRepositoryImpl(dataSource)
}