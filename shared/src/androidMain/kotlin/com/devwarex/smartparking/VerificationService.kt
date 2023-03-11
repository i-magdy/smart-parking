package com.devwarex.smartparking

import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider


class AndroidVerificationService: VerificationService{


}

actual fun getVerificationService(): VerificationService = AndroidVerificationService()