package com.msg.data.remote.datasource.datasource

import com.msg.data.remote.dto.BusinessCard

interface BusinessCardDataSource {
    suspend fun getBusinessCards(): List<BusinessCard>?
}