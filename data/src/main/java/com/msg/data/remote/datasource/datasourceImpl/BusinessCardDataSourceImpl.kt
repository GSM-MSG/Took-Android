package com.msg.data.remote.datasource.datasourceImpl

import com.msg.data.remote.datasource.datasource.BusinessCardDataSource
import com.msg.data.remote.dto.businessCards.request.DataPostBusinessCardsRequest
import com.msg.data.remote.network.BusinessCardAPI
import retrofit2.Response
import javax.inject.Inject

class BusinessCardDataSourceImpl @Inject constructor(
    private val api: BusinessCardAPI
) : BusinessCardDataSource {
    override suspend fun postBusinessCard(body: DataPostBusinessCardsRequest): Response<Void> {
        return api.postBusinessCard(body = body)
    }
}