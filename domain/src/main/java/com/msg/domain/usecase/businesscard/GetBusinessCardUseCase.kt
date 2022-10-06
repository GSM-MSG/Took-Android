package com.msg.domain.usecase.businesscard

import com.msg.domain.repository.BusinessCardRepository
import javax.inject.Inject

class GetBusinessCardUseCase @Inject constructor(
    private val repository: BusinessCardRepository
) {
    suspend fun getCards() = repository.getBusinessCards()
}