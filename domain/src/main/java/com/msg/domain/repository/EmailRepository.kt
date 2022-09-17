package com.msg.domain.repository

import retrofit2.Response

interface EmailRepository {
    suspend fun sendEmail(email: String): Response<Void>
}