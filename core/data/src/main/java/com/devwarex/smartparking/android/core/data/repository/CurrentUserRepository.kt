package com.devwarex.smartparking.android.core.data.repository

import kotlinx.coroutines.flow.Flow


interface CurrentUserRepository {
    fun isUserLogged(): Boolean
    suspend fun isUserRegistered(): Boolean

    suspend fun signup(name: String): Boolean
}