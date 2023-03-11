package com.devwarex.smartparking

class IOSCurrentUser : CurrentUser{
    override fun isUserLogged(): Boolean {
        TODO("Not yet implemented")
    }

    override  fun isUserSignedUp(): Boolean {
        TODO("Not yet implemented")
    }
}

actual fun getCurrentUser(): CurrentUser = IOSCurrentUser()