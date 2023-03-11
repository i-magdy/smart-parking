package com.devwarex.smartparking

class IOSVerificationService: VerificationService{

}

actual fun getVerificationService(): VerificationService = IOSVerificationService()