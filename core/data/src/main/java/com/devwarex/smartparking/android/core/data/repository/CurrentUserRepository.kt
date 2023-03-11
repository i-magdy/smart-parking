package com.devwarex.smartparking.android.core.data.repository

interface CurrentUserRepository {
    fun isUserLogged(): Boolean
    fun isUserRegistered(): Boolean
}