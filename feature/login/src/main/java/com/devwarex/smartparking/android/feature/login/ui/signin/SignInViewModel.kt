package com.devwarex.smartparking.android.feature.login.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devwarex.smartparking.android.core.data.repository.VerificationRepository
import com.google.firebase.auth.PhoneAuthOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repo: VerificationRepository
): ViewModel() {

    val uiState = repo.uiState
    fun init(
        builder: PhoneAuthOptions.Builder
    ) = viewModelScope.launch{
        repo.init(builder)
    }


    fun setPhone(
        phone: String
    ) = viewModelScope.launch{
        repo.setPhoneNumber(phone)
    }

    fun setCode(
        code: String
    ) = viewModelScope.launch {
        repo.setVerificationCode(code)
    }


    fun requestCode() = viewModelScope.launch{
        repo.requestVerificationCode()
    }

    fun verify() = viewModelScope.launch {
        repo.verifyPhoneNumber()
    }

}