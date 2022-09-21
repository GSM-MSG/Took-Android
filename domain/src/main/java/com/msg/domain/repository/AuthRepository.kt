package com.msg.domain.repository

import com.msg.domain.param.InfoParam
import retrofit2.Response

interface AuthRepository {
    suspend fun signUp(info: InfoParam): Response<Void>
}