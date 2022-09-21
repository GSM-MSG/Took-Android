package com.msg.data.remote.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HEAD
import retrofit2.http.POST
import retrofit2.http.Query

interface EmailAPI {
    @POST("/email")
    suspend fun sendEmail(
        @Body email: String
    ): Response<Void>

    @HEAD("/email")
    suspend fun verifyCode(
        @Query("email") email: String,
        @Query("authKey") code: String
    ): Response<Void>
}