package com.msg.app.di

import com.msg.domain.repository.BusinessCardRepository
import com.msg.domain.repository.ImageRepository
import com.msg.domain.usecase.businessCard.PostBusinessCardUseCase
import com.msg.domain.usecase.image.ImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideImageUseCase(repository: ImageRepository): ImageUseCase = ImageUseCase(repository)

    @Provides
    @Singleton
    fun provideBusinessCardUseCase(repository: BusinessCardRepository): PostBusinessCardUseCase =
        PostBusinessCardUseCase(repository)
}