package com.devwarex.smartparking.android.core.data.repository

import com.devwarex.smartparking.android.core.common.VerifyUiState
import com.google.firebase.auth.PhoneAuthOptions
import kotlinx.coroutines.flow.MutableStateFlow

interface VerificationRepository {
    val uiState: MutableStateFlow<VerifyUiState>
    suspend fun init(builder: PhoneAuthOptions.Builder)
    suspend fun setPhoneNumber(phone: String)
    suspend fun setVerificationCode(code: String)
    suspend fun requestVerificationCode()
    suspend fun verifyPhoneNumber()
    suspend fun succeed(isSucceed: Boolean)
    suspend fun clearError()
    fun cancelJob()
}