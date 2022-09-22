package com.msg.data.remote.network

import com.msg.data.remote.dto.businessCards.request.DataPostBusinessCardsRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface BusinessCardAPI {
    @POST("business-cards/")
    suspend fun postBusinessCard(
        @Body body: DataPostBusinessCardsRequest
    ): Response<Void>
}