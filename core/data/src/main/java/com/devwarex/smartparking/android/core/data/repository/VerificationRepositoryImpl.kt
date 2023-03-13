package com.devwarex.smartparking.android.core.data.repository


import com.devwarex.smartparking.android.core.common.VerifyUiState
import com.devwarex.smartparking.android.core.common.util.VerifyUiError
import com.google.firebase.auth.PhoneAuthOptions
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import javax.inject.Inject

class VerificationRepositoryImpl @Inject constructor(
    private val verificationService: VerificationServiceRepository
): VerificationRepository {

    override val uiState: MutableStateFlow<VerifyUiState> = MutableStateFlow(
        VerifyUiState()
    )

    private val coroutine = CoroutineScope(Dispatchers.IO + SupervisorJob())

    init {
        coroutine.launch {
            verificationService.state.collect{ state ->
                //update ui when code is requested
                if (state.codeRequested){
                    uiState.getAndUpdate {
                        it.copy(
                            isCodeRequested = true,
                            error = VerifyUiError.NONE
                        )
                    }
                }
                //update ui when code is sent to user
                uiState.getAndUpdate {
                    it.copy(isCodeSent = state.codeSent)
                }
                //update ui when phone number is wrong
                if (state.wrongPhone){
                    uiState.getAndUpdate {
                        it.copy(
                            isCodeRequested = false,
                            error = VerifyUiError.INVALID_PHONE
                        )
                    }
                }
                //update ui if code is wrong
                if (state.wrongCode){
                    uiState.getAndUpdate {
                        it.copy(
                            isVerifying = false,
                            error = VerifyUiError.INVALID_CODE
                        )
                    }
                }
                //update ui when succeed verify
                if (state.isSucceed){
                    succeed(
                        isSucceed = true
                    )
                }

            }
        }
    }

    override suspend fun init(
        builder: PhoneAuthOptions.Builder
    ) {
        verificationService.initService(
            builder = builder
        )
    }



    override suspend fun setPhoneNumber(
        phone: String
    ) {
        val p = uiState.value.phone
        if (p != phone){
            uiState.getAndUpdate {
                it.copy(phone = phone)
            }
        }
    }

    override suspend fun setVerificationCode(
        code: String
    ) {
        uiState.getAndUpdate {
            it.copy(code = code)
        }
    }


    override suspend fun requestVerificationCode() {
        val phone = uiState.value.phone
        if (phone.isNotBlank() && phone.length > 7) {
            verificationService.requestCode("+2$phone")
        }
    }

    override suspend fun verifyPhoneNumber() {
        verificationService.verify(uiState.value.code)
        uiState.getAndUpdate {
            it.copy(isVerifying = true)
        }
    }

    override suspend fun succeed(
        isSucceed: Boolean
    ) {

        uiState.getAndUpdate {
            it.copy(
                isSuccess = isSucceed,
                isCodeSent = true,
                isCodeRequested = true
            )
        }

    }
    override suspend fun clearError() {
        uiState.getAndUpdate {
            it.copy(error = VerifyUiError.NONE)
        }
    }


    override fun cancelJob() {
        coroutine.cancel()
        verificationService.cancelJob()
    }
}