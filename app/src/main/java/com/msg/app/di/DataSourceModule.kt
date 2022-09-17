package com.msg.app.di

import com.msg.data.remote.datasource.datasourceImpl.EmailDataSourceImpl
import com.msg.data.remote.datasource.datasourceImpl.ImageDataSourceImpl
import com.msg.data.remote.network.EmailAPI
import com.msg.data.remote.network.ImageAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideImageDataSource(api: ImageAPI) = ImageDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideEmailDataSource(api: EmailAPI) = EmailDataSourceImpl(api)
}