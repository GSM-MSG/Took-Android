package com.msg.presentation.viewmodel.card_storage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.msg.domain.usecase.businesscard.GetBusinessCardUseCase
import com.msg.presentation.utils.SingleLiveEvent
import javax.inject.Inject

class CardStorageViewModel @Inject constructor(
    private val getBusinessCardUseCase: GetBusinessCardUseCase
): ViewModel() {
    private val _vertical = SingleLiveEvent<Boolean>()
    val vertical: LiveData<Boolean> get() = _vertical

    fun setValue(boolean: Boolean) {
        _vertical.value = boolean
    }
}