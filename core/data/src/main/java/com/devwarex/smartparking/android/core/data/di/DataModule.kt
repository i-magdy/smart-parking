package com.devwarex.smartparking.android.core.data.di

import com.devwarex.smartparking.android.core.data.repository.CurrentUserImpl
import com.devwarex.smartparking.android.core.data.repository.CurrentUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsCurrentUserRepository(
        userImpl: CurrentUserImpl
    ): CurrentUserRepository

}