package com.msg.data.repository

import com.msg.data.remote.datasource.datasource.EmailDataSource
import com.msg.domain.repository.EmailRepository
import retrofit2.Response
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val emailDataSource: EmailDataSource
): EmailRepository {
    override suspend fun sendEmail(email: String): Response<Void> {
        return emailDataSource.sendEmail(email = email)
    }

    override suspend fun verifyCode(email: String, code: String): Response<Void> {
        return emailDataSource.verifyCode(email = email, code = code)
    }
}