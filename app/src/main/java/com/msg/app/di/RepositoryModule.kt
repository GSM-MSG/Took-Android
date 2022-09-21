package com.msg.app.di

import com.msg.data.remote.datasource.datasource.AuthDataSource
import com.msg.data.remote.datasource.datasource.EmailDataSource
import com.msg.data.remote.datasource.datasource.ImageDataSource
import com.msg.data.repository.AuthRepositoryImpl
import com.msg.data.repository.EmailRepositoryImpl
import com.msg.data.repository.ImageRepositoryImpl
import com.msg.domain.repository.AuthRepository
import com.msg.domain.repository.EmailRepository
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
    fun provideEmailRepository(dataSource: EmailDataSource): EmailRepository = EmailRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideAuthRepository(dataSource: AuthDataSource): AuthRepository = AuthRepositoryImpl(dataSource)
}