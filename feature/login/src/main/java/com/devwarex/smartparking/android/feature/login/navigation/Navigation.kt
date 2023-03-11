package com.devwarex.smartparking.android.feature.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devwarex.smartparking.android.feature.login.ui.Splash
import com.devwarex.smartparking.android.feature.login.ui.signin.SignInScreen

const val loginSplashScreen = "splash_screen"
const val loginScreen = "login_screen"
const val signUpScreen = "sign_up_screen"

fun NavGraphBuilder.splashScreen(
    navigateToSignIn: () -> Unit
){
    composable(route = loginSplashScreen){
        Splash(
            onNavigateToLogin = navigateToSignIn
        )
    }
}


fun NavGraphBuilder.signInScreen(
    navigateToSignUp: () -> Unit
){
    composable(
        route = loginScreen
    ){
        SignInScreen(
            onNavigateToSignUp = navigateToSignUp
        )
    }
}