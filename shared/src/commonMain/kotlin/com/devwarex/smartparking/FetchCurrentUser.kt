package com.devwarex.smartparking

import kotlinx.coroutines.flow.Flow

class FetchCurrentUser {
    private val currentUser: CurrentUser = getCurrentUser()

    val isLogged: Boolean = currentUser.isUserLogged()

    suspend fun isUserSignedUp(): Boolean = currentUser.isUserSignedUp()

    suspend fun signup(
        name: String
    ): Boolean {
        return currentUser.signupUser(name)
    }

}