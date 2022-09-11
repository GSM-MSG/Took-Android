package com.msg.data.repository

import com.msg.data.remote.datasource.datasource.ImageDataSource
import com.msg.domain.repository.ImageRepository
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val dataSource: ImageDataSource
) : ImageRepository {
    override suspend fun postImage(image: List<MultipartBody.Part>): Response<List<String>> {
        return dataSource.postImage(image = image)
    }
}