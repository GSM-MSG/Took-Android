package com.msg.app.di

import com.msg.data.remote.datasource.datasource.AuthDataSource
import com.msg.data.remote.datasource.datasource.BusinessCardDataSource
import com.msg.data.remote.datasource.datasource.EmailDataSource
import com.msg.data.remote.datasource.datasourceImpl.AuthDataSourceImpl
import com.msg.data.remote.datasource.datasourceImpl.BusinessCardDataSourceImpl
import com.msg.data.remote.datasource.datasourceImpl.EmailDataSourceImpl
import com.msg.data.remote.datasource.datasourceImpl.ImageDataSourceImpl
import com.msg.data.remote.network.AuthAPI
import com.msg.data.remote.network.BusinessCardAPI
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
    fun provideEmailDataSource(api: EmailAPI): EmailDataSource = EmailDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideAuthDataSource(api: AuthAPI): AuthDataSource = AuthDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideBusinessCardDataSource(api: BusinessCardAPI): BusinessCardDataSource =
        BusinessCardDataSourceImpl(api)
}