package com.devwarex.smartparking.android.core.data.repository

import com.devwarex.smartparking.FetchCurrentUser
import javax.inject.Inject

class CurrentUserImpl @Inject constructor(
    private val user: FetchCurrentUser
): CurrentUserRepository {
    override fun isUserLogged(): Boolean = user.isLogged

    override fun isUserRegistered(): Boolean = user.isLogged

}