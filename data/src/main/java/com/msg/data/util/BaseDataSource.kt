package com.msg.data.util

import retrofit2.HttpException

abstract class BaseDataSource {
    suspend inline fun <T> safeApiCall(function: suspend () -> T): T? {
        return try {
            function.invoke()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}