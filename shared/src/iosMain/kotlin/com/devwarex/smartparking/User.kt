package com.devwarex.smartparking

import kotlinx.coroutines.flow.Flow

class IOSCurrentUser : CurrentUser{
    override fun isUserLogged(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun isUserSignedUp(): Boolean{
        TODO("Not yet implemented")
    }

    override suspend fun signupUser(name: String): Boolean {
        TODO("Not yet implemented")
    }
}

actual fun getCurrentUser(): CurrentUser = IOSCurrentUser()