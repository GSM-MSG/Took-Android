package com.msg.domain.usecase.email

import com.msg.domain.repository.EmailRepository
import javax.inject.Inject

class VerifyCodeUseCase @Inject constructor(
    private val repository: EmailRepository
) {
    suspend fun verifyCode(email: String, code: String) = repository.verifyCode(email = email, code = code)
}