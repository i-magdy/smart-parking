package com.devwarex.smartparking.android.core.data.di

import com.devwarex.smartparking.android.core.data.repository.VerificationRepository
import com.devwarex.smartparking.android.core.data.repository.VerificationRepositoryImpl
import com.devwarex.smartparking.android.core.data.repository.VerificationServiceRepository
import com.devwarex.smartparking.android.core.data.repository.VerificationServiceRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface VerifyModule {

    @Binds
    fun bindsVerificationService(
        verificationService: VerificationServiceRepositoryImpl
    ): VerificationServiceRepository

    @Binds
    fun bindsVerificationRepository(
        verificationRepo: VerificationRepositoryImpl
    ): VerificationRepository

}