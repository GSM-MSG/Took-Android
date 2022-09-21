package com.msg.presentation.viewmodel.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msg.domain.usecase.email.SendEmailUseCase
import com.msg.domain.usecase.email.VerifyCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val sendEmailUseCase: SendEmailUseCase,
    private val verifyCodeUseCase: VerifyCodeUseCase
): ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password
    private val _state = MutableLiveData<Int>()
    val state: LiveData<Int> get() = _state

    fun saveInfo(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun sendEmail() = viewModelScope.launch {
        try {
            sendEmailUseCase.sendEmail(email.value!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun verifyCode(code: String) = viewModelScope.launch {
        try {
            val response = verifyCodeUseCase.verifyCode(email.value!!, code)
            _state.value = response.code()
            Log.d("안녕", "verifyCode: ${response.code()}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}