package com.msg.presentation.viewmodel.businesscard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msg.domain.dto.businessCards.request.DomainPostBusinessCardsRequest
import com.msg.domain.usecase.businessCard.PostBusinessCardUseCase
import com.msg.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class BusinessCardViewmodel @Inject constructor(
    private val usecase: PostBusinessCardUseCase
) : ViewModel() {

    private val TAG = "BusinessCardVM"

    private val _originalCardStatus = SingleLiveEvent<Int>()
    val originalCardStatus: LiveData<Int> get() = _originalCardStatus

    fun postBusinessCard(frontUrl: String, backUrl: String) =
        try {
            viewModelScope.launch {
                val response = usecase.postBusinessCard(
                    body = DomainPostBusinessCardsRequest(
                        frontUrl = frontUrl,
                        backUrl = backUrl
                    )
                )
                _originalCardStatus.value = response.code()
            }
        } catch (e: Exception) {
            Log.d(TAG, "error: $e")
        }
}