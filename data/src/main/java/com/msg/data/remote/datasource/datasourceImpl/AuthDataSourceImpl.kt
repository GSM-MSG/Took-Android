package com.msg.data.remote.datasource.datasourceImpl

import com.msg.data.remote.datasource.datasource.AuthDataSource
import com.msg.data.remote.dto.request.InfoRequest
import com.msg.data.remote.dto.response.TokenResponse
import com.msg.data.remote.network.AuthAPI
import retrofit2.Response
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authAPI: AuthAPI
): AuthDataSource {
    override suspend fun signUp(info: InfoRequest): Response<Void> {
        return authAPI.signUp(info = info)
    }

    override suspend fun login(info: InfoRequest): Response<TokenResponse> {
        return authAPI.login(info = info)
    }
}