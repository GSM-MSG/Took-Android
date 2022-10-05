package com.msg.data.remote.network

import com.msg.data.remote.dto.response.GetBusinessCardResponse
import retrofit2.Response
import retrofit2.http.GET

interface BusinessCardsAPI {
    @GET("/business-cards")
    suspend fun getBusinessCards() : Response<GetBusinessCardResponse>
}