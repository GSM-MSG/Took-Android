package com.msg.data.remote.dto.request

import com.google.gson.annotations.SerializedName
import com.msg.domain.param.InfoParam

data class InfoRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)

fun InfoParam.toRequest() = InfoRequest(
    email = email,
    password = password
)
