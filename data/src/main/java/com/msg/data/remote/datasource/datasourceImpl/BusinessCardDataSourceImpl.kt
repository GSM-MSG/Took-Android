package com.msg.data.remote.datasource.datasourceImpl

import com.msg.data.remote.datasource.datasource.BusinessCardDataSource
import com.msg.data.remote.dto.response.GetBusinessCardResponse
import com.msg.data.remote.network.BusinessCardsAPI
import retrofit2.Response
import javax.inject.Inject

class BusinessCardDataSourceImpl @Inject constructor(
    private val cardApi: BusinessCardsAPI
) : BusinessCardDataSource {
    override suspend fun getBusinessCards(): Response<GetBusinessCardResponse> {
        return cardApi.getBusinessCards()
    }
}