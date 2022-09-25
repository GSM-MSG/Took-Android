package com.msg.data.remote.datasource.datasource

import com.msg.data.remote.dto.request.InfoRequest
import retrofit2.Response

interface AuthDataSource {
    suspend fun signUp(info: InfoRequest): Response<Void>
}