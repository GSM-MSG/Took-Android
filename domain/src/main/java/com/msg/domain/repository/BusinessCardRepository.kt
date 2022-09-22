package com.msg.domain.repository

import com.msg.domain.dto.businessCards.request.DomainPostBusinessCardsRequest
import retrofit2.Response

interface BusinessCardRepository {
    suspend fun postBusinessCard(body: DomainPostBusinessCardsRequest): Response<Void>
}