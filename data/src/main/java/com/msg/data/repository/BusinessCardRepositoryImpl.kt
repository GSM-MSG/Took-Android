package com.msg.data.repository

import com.msg.data.mapper.BusinessCardMapper
import com.msg.data.remote.datasource.datasource.BusinessCardDataSource
import com.msg.domain.param.BusinessCardParam
import com.msg.domain.repository.BusinessCardRepository
import javax.inject.Inject

class BusinessCardRepositoryImpl @Inject constructor(
    private val cardDataSource: BusinessCardDataSource
): BusinessCardRepository {
    override suspend fun getBusinessCards(): List<BusinessCardParam>? {
        return BusinessCardMapper.businessCardMapper(cardDataSource.getBusinessCards())
    }
}