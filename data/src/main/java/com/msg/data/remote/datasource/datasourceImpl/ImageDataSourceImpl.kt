package com.msg.data.remote.datasource.datasourceImpl

import com.msg.data.remote.datasource.datasource.ImageDataSource
import com.msg.data.remote.network.ImageAPI
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject

class ImageDataSourceImpl @Inject constructor(
    private val api: ImageAPI
): ImageDataSource {
    override suspend fun postImage(image: List<MultipartBody.Part>): Response<List<String>> {
        return api.postImage(files = image)
    }
}