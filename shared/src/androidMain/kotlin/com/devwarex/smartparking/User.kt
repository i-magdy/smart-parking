package com.devwarex.smartparking

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AndroidCurrentUser : CurrentUser{
    override fun isUserLogged(): Boolean = Firebase.auth.currentUser != null

    override fun isUserSignedUp(): Boolean {
        return false
    }
}

actual fun getCurrentUser(): CurrentUser = AndroidCurrentUser()