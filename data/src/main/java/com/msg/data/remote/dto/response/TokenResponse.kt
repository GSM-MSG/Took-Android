package com.msg.data.remote.dto.response

import com.google.gson.annotations.SerializedName
import com.msg.domain.entity.TokenEntity

data class TokenResponse(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("expiredAt")
    val expiredAt: String
)

fun TokenResponse.toEntity() = TokenEntity(
    accessToken = accessToken,
    refreshToken = refreshToken,
    expiredAt = expiredAt
)