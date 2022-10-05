package com.msg.data.mapper

import com.msg.data.remote.dto.BusinessCard
import com.msg.domain.param.BusinessCardParam

object BusinessCardMapper {
    fun businessCardMapper (
        dataResponse: List<BusinessCard>?
    ): List<BusinessCardParam>? {
        return if (dataResponse != null) {
            dataResponse.map {
                BusinessCardParam(
                    uuid = it.uuid,
                    frontUrl = it.frontUrl,
                    backUrl = it.backUrl,
                    createAt = it.createAt,
                    updateAt = it.updateAt
                )
            }
        } else dataResponse
    }
}