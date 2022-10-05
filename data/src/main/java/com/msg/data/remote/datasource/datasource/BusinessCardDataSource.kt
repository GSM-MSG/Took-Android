package com.msg.data.remote.datasource.datasource

import com.msg.data.remote.dto.response.GetBusinessCardResponse
import retrofit2.Response

interface BusinessCardDataSource {
    suspend fun getBusinessCards(): Response<GetBusinessCardResponse>
}