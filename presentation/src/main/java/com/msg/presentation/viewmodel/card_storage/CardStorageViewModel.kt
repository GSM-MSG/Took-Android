package com.msg.presentation.viewmodel.card_storage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msg.domain.usecase.businesscard.GetBusinessCardUseCase
import com.msg.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardStorageViewModel @Inject constructor(
    private val getBusinessCardUseCase: GetBusinessCardUseCase
) : ViewModel() {

    private val TAG = "CardStorageVM"

    private val _cardList = SingleLiveEvent<ArrayList<String>>()
    val cardList: LiveData<ArrayList<String>> get() = _cardList

    fun gerCards() = viewModelScope.launch {
        try {
            val response = getBusinessCardUseCase.getCards()
            setCardListValue(
                response!!.map { it.frontUrl } as ArrayList<String>,
                response.map { it.backUrl } as ArrayList<String>
            )
        } catch (e: Exception) {
            Log.d(TAG, "error : $e")
        }
    }

    private fun setCardListValue(frontUrlList: ArrayList<String>, backUrlList: ArrayList<String>) {
        for (i in 0..frontUrlList.size) {
            _cardList.value!!.add(frontUrlList[i])
            _cardList.value!!.add(backUrlList[i])
        }
    }
}