package com.msg.data.remote.datasource.datasourceImpl

import com.msg.data.remote.datasource.datasource.EmailDataSource
import com.msg.data.remote.network.EmailAPI
import retrofit2.Response
import javax.inject.Inject

class EmailDataSourceImpl @Inject constructor(
    private val emailAPI: EmailAPI
): EmailDataSource {
    override suspend fun sendEmail(email: String): Response<Void> {
        return emailAPI.sendEmail(email = email)
    }

    override suspend fun verifyCode(email: String, code: String): Response<Void> {
        return emailAPI.verifyCode(email = email, code = code)
    }
}