package com.devwarex.smartparking.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.devwarex.smartparking.android.feature.login.navigation.*
import com.google.firebase.auth.PhoneAuthOptions


@Composable
fun LoginNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = loginSplashScreen,
    phoneServiceBuilder: PhoneAuthOptions.Builder
){
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ){
        splashScreen {
            navHostController.navigate(loginScreen){
                navHostController.popBackStack()
            }
        }

        signInScreen(
            phoneServiceBuilder = phoneServiceBuilder
        ){
            navHostController.navigate(signUpScreen){
                navHostController.popBackStack()
            }
        }
    }
}


