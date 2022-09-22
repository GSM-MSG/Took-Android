package com.msg.domain.usecase.businessCard

import com.msg.domain.dto.businessCards.request.DomainPostBusinessCardsRequest
import com.msg.domain.repository.BusinessCardRepository
import javax.inject.Inject

class PostBusinessCardUseCase @Inject constructor(
    private val repository: BusinessCardRepository
) {
    suspend fun postBusinessCard(body: DomainPostBusinessCardsRequest) =
        repository.postBusinessCard(body = body)
}