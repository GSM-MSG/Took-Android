package com.msg.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msg.domain.usecase.image.ImageUseCase
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

class ImageViewModel @Inject constructor(
    private val useCase: ImageUseCase
) : ViewModel() {
    fun postImage(imageList: List<MultipartBody.Part>) {
        viewModelScope.launch {
            useCase.postImage(imageList)
        }
    }
}