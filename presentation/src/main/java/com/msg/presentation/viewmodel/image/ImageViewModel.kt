package com.msg.presentation.viewmodel.image

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msg.domain.usecase.image.ImageUseCase
import com.msg.presentation.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val useCase: ImageUseCase
) : ViewModel() {

    private val TAG = "ImageVM"

    private val _imageUrl = SingleLiveEvent<List<String>>()
    val imageUrl: LiveData<List<String>> get() = _imageUrl

    private val _imageStatus = SingleLiveEvent<Boolean>()
    val imageStatus: LiveData<Boolean> get() = _imageStatus

    fun postImage(imageList: List<MultipartBody.Part>) =
        viewModelScope.launch {
            try {
                val response = useCase.postImage(imageList)
                if (response.isSuccessful) {
                    _imageStatus.value = true
                    _imageUrl.value = response.body()
                } else {
                    _imageStatus.value = false
                }
            } catch (e: Exception) {
                Log.d(TAG, "error : $e")
            }
        }
}