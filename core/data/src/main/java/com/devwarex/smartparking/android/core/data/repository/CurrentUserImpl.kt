package com.devwarex.smartparking.android.core.data.repository

import com.devwarex.smartparking.FetchCurrentUser
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class CurrentUserImpl @Inject constructor(
    private val user: FetchCurrentUser
): CurrentUserRepository {
    override fun isUserLogged(): Boolean = user.isLogged

    override suspend fun isUserRegistered(): Boolean = user.isUserSignedUp()
    override suspend fun signup(name: String): Boolean {
        return user.signup(name)
    }

}