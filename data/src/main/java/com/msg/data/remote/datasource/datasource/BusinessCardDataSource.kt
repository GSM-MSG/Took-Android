package com.msg.data.remote.datasource.datasource

import com.msg.data.remote.dto.businessCards.request.DataPostBusinessCardsRequest
import retrofit2.Response

interface BusinessCardDataSource {
    suspend fun postBusinessCard(body: DataPostBusinessCardsRequest): Response<Void>
}