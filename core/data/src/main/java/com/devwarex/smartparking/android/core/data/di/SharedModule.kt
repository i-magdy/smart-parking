package com.devwarex.smartparking.android.core.data.di

import com.devwarex.smartparking.FetchCurrentUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharedModule {

    @Provides
    fun providesCurrentUser(): FetchCurrentUser = FetchCurrentUser()

}