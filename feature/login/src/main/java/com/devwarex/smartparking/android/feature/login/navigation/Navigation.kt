package com.devwarex.smartparking.android.feature.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.devwarex.smartparking.android.feature.login.ui.signup.SignupScreen
import com.devwarex.smartparking.android.feature.login.ui.splash.Splash
import com.devwarex.smartparking.android.feature.login.ui.signin.SignInScreen
import com.google.firebase.auth.PhoneAuthOptions

const val loginSplashScreen = "splash_screen"
const val loginScreen = "login_screen"
const val signUpScreen = "sign_up_screen"

fun NavGraphBuilder.splashScreen(
    navigateToSignIn: () -> Unit,
    navigateToSignUp: () -> Unit
){
    composable(route = loginSplashScreen){
        Splash(
            onNavigateToLogin = navigateToSignIn,
            onNavigateToSignUp = navigateToSignUp
        )
    }
}


fun NavGraphBuilder.signInScreen(
    phoneServiceBuilder: PhoneAuthOptions.Builder,
    navigateToSignUp: () -> Unit
){
    composable(
        route = loginScreen
    ){
        SignInScreen(
            phoneServiceBuilder = phoneServiceBuilder,
            onNavigateToSignUp = navigateToSignUp
        )
    }
}

fun NavGraphBuilder.signupScreen(){
    composable(
        route = signUpScreen
    ){
        SignupScreen()
    }
}