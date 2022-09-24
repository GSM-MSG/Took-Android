package com.msg.data.remote.network

import com.msg.data.remote.dto.request.InfoRequest
import com.msg.data.remote.dto.response.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {
    @POST("/auth/signup")
    suspend fun signUp(
        @Body info: InfoRequest
    ): Response<Void>

    @POST("/auth")
    suspend fun login(
        @Body info: InfoRequest
    ): Response<TokenResponse>
}