package com.msg.data.repository

import com.msg.data.remote.datasource.datasource.AuthDataSource
import com.msg.data.remote.dto.request.toRequest
import com.msg.data.remote.dto.response.toEntity
import com.msg.data.util.BaseDataSource
import com.msg.domain.entity.TokenEntity
import com.msg.domain.param.InfoParam
import com.msg.domain.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
): AuthRepository, BaseDataSource() {
    override suspend fun signUp(info: InfoParam): Response<Void> {
        return authDataSource.signUp(info = info.toRequest())
    }

    override suspend fun login(info: InfoParam): Response<TokenEntity> {
        return safeApiCall { authDataSource.login(info = info.toRequest()) }.body()
    }
}