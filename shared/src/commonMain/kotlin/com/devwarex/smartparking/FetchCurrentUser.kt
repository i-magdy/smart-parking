package com.devwarex.smartparking

class FetchCurrentUser {
    private val currentUser: CurrentUser = getCurrentUser()

    val isLogged: Boolean = currentUser.isUserLogged()


}