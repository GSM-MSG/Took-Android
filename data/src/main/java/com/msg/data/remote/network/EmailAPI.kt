package com.msg.data.remote.network

import retrofit2.Response
import retrofit2.http.POST

interface EmailAPI {
    @POST("/email")
    suspend fun sendEmail(email: String): Response<Void>
}