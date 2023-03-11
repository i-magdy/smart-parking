package com.devwarex.smartparking

interface CurrentUser {
    fun isUserLogged(): Boolean
    fun isUserSignedUp(): Boolean
}

expect fun getCurrentUser(): CurrentUser