package com.devwarex.smartparking.android.core.data.repository

import com.devwarex.smartparking.android.core.common.VerificationServiceState
import com.google.firebase.auth.PhoneAuthOptions
import kotlinx.coroutines.flow.MutableStateFlow

interface VerificationServiceRepository {
    val state: MutableStateFlow<VerificationServiceState>
    fun initService(builder: PhoneAuthOptions.Builder)
    fun requestCode(phone: String)
    fun verify(code: String)
    fun cancelJob()
}