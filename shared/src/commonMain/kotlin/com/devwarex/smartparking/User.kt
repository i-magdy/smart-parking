package com.devwarex.smartparking

import kotlinx.coroutines.flow.Flow

interface CurrentUser {
    fun isUserLogged(): Boolean
    suspend fun isUserSignedUp(): Boolean

    suspend fun signupUser(name: String): Boolean
}

expect fun getCurrentUser(): CurrentUser