package com.msg.domain.repository

import retrofit2.Response

interface EmailRepository {
    suspend fun sendEmail(email: String): Response<Void>

    suspend fun verifyCode(email: String, code: String): Response<Void>
}