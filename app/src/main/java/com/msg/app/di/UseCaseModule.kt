package com.msg.app.di

import com.msg.domain.repository.AuthRepository
import com.msg.domain.repository.BusinessCardRepository
import com.msg.domain.repository.EmailRepository
import com.msg.domain.repository.ImageRepository
import com.msg.domain.usecase.auth.SignUpUseCase
import com.msg.domain.usecase.businessCard.PostBusinessCardUseCase
import com.msg.domain.usecase.email.SendEmailUseCase
import com.msg.domain.usecase.email.VerifyCodeUseCase
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
    fun provideSendEmailUseCase(repository: EmailRepository) = SendEmailUseCase(repository)

    @Provides
    @Singleton
    fun provideVerifyCodeUseCase(repository: EmailRepository) = VerifyCodeUseCase(repository)

    @Provides
    @Singleton
    fun provideSignUpUseCase(repository: AuthRepository) = SignUpUseCase(repository)

    @Provides
    @Singleton
    fun provideBusinessCardUseCase(repository: BusinessCardRepository): PostBusinessCardUseCase =
        PostBusinessCardUseCase(repository)
}