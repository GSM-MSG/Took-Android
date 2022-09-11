package com.msg.domain.usecase.image

import com.msg.domain.repository.ImageRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class ImageUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend fun postImage(image: List<MultipartBody.Part>) = repository.postImage(image = image)
}