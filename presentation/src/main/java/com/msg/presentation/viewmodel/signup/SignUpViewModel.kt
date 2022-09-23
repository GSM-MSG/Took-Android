package com.msg.presentation.viewmodel.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msg.domain.param.InfoParam
import com.msg.domain.usecase.auth.SignUpUseCase
import com.msg.domain.usecase.email.SendEmailUseCase
import com.msg.domain.usecase.email.VerifyCodeUseCase
import com.msg.presentation.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val sendEmailUseCase: SendEmailUseCase,
    private val verifyCodeUseCase: VerifyCodeUseCase,
    private val signUpUseCase: SignUpUseCase
): ViewModel() {
    private val _email = SingleLiveEvent<String>()
    val email: LiveData<String> get() = _email
    private val _password = SingleLiveEvent<String>()
    val password: LiveData<String> get() = _password
    private val _state = SingleLiveEvent<Int>()
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
            _state.value = verifyCodeUseCase.verifyCode(email.value!!, code).code()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun signUp() = viewModelScope.launch {
        try {
            signUpUseCase.signUp(InfoParam(email = email.value!!, password = password.value!!))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}