package com.msg.presentation.viewmodel.card_storage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msg.domain.param.BusinessCardParam
import com.msg.domain.usecase.businesscard.GetBusinessCardUseCase
import com.msg.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardStorageViewModel @Inject constructor(
    private val getBusinessCardUseCase: GetBusinessCardUseCase
) : ViewModel() {

    private val TAG = "CardStorageVM"

    private val _vertical = SingleLiveEvent<Boolean>()
    val vertical: LiveData<Boolean> get() = _vertical

    private val _cardList = SingleLiveEvent<List<BusinessCardParam>>()
    val cardList: LiveData<List<BusinessCardParam>> get() = _cardList

    fun gerCards() = viewModelScope.launch {
        try {
            _cardList.value = getBusinessCardUseCase.getCards()
        } catch (e: Exception) {
            Log.d(TAG, "error : $e")
        }
    }

    fun setValue(boolean: Boolean) {
        _vertical.value = boolean
    }
}