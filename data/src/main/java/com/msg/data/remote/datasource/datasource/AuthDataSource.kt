package com.msg.data.remote.datasource.datasource

import com.msg.data.remote.dto.request.InfoRequest
import com.msg.data.remote.dto.response.TokenResponse
import retrofit2.Response

interface AuthDataSource {
    suspend fun signUp(info: InfoRequest): Response<Void>

    suspend fun login(info: InfoRequest): Response<TokenResponse>
}