package com.devwarex.smartparking.android.core.common

import com.devwarex.smartparking.android.core.common.util.VerifyUiError

data class VerifyUiState(
    val phone: String = "",
    val code: String = "",
    val isRequestingPhone: Boolean = false,
    val isCodeRequested: Boolean = false,
    val isCodeSent: Boolean = false,
    val isVerifying: Boolean = false,
    val isSuccess: Boolean = false,
    val error: VerifyUiError = VerifyUiError.NONE
)
