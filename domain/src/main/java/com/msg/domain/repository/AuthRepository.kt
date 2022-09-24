package com.msg.domain.repository

import com.msg.domain.entity.TokenEntity
import com.msg.domain.param.InfoParam
import retrofit2.Response

interface AuthRepository {
    suspend fun signUp(info: InfoParam): Response<Void>

    suspend fun login(info: InfoParam): Response<TokenEntity>
}