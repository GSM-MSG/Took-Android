package com.msg.domain.entity

data class TokenEntity(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String
)
