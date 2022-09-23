package com.msg.domain.usecase.auth

import com.msg.domain.param.InfoParam
import com.msg.domain.repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun signUp(info: InfoParam) = authRepository.signUp(info = info)
}