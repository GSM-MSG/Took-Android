package com.msg.domain.usecase.email

import com.msg.domain.repository.EmailRepository
import javax.inject.Inject

class SendEmailUseCase @Inject constructor(
    private val repository: EmailRepository
) {
    suspend fun sendEmail(email: String) = repository.sendEmail(email = email)
}