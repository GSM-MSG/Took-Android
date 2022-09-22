package com.msg.data.repository

import com.msg.data.remote.datasource.datasource.BusinessCardDataSource
import com.msg.data.remote.dto.businessCards.request.DataPostBusinessCardsRequest
import com.msg.domain.dto.businessCards.request.DomainPostBusinessCardsRequest
import com.msg.domain.repository.BusinessCardRepository
import retrofit2.Response
import javax.inject.Inject

class BusinessCardRepositoryImpl @Inject constructor(
    private val dataSource: BusinessCardDataSource
) : BusinessCardRepository {
    override suspend fun postBusinessCard(body: DomainPostBusinessCardsRequest): Response<Void> {
        return dataSource.postBusinessCard(
            body = DataPostBusinessCardsRequest(
                frontUrl = body.frontUrl,
                backUrl = body.backUrl
            )
        )
    }
}