package com.msg.data.remote.datasource.datasource

import retrofit2.Response

interface EmailDataSource {
    suspend fun sendEmail(email: String): Response<Void>

    suspend fun verifyCode(email: String, code: String): Response<Void>
}