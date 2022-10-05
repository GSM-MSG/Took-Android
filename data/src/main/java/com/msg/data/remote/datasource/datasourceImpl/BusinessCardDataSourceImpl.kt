package com.msg.data.remote.datasource.datasourceImpl

import com.msg.data.remote.datasource.datasource.BusinessCardDataSource
import com.msg.data.remote.dto.BusinessCard
import com.msg.data.remote.network.BusinessCardsAPI
import javax.inject.Inject

class BusinessCardDataSourceImpl @Inject constructor(
    private val cardApi: BusinessCardsAPI
) : BusinessCardDataSource {
    override suspend fun getBusinessCards(): List<BusinessCard>? {
        return cardApi.getBusinessCards().body()
    }
}