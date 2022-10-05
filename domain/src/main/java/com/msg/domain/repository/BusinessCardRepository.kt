package com.msg.domain.repository

import com.msg.domain.param.BusinessCardParam

interface BusinessCardRepository {
    suspend fun getBusinessCards(): List<BusinessCardParam>?
}