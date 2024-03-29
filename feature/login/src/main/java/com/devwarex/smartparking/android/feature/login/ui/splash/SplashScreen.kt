package com.devwarex.smartparking.android.feature.login.ui.splash

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.runtime.collectAsState
import com.devwarex.smartparking.android.ui.R
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun Splash(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToLogin: () -> Unit,
    onNavigateToSignUp: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.logo),
            contentDescription ="my logo"
        )
        Spacer(modifier = Modifier.padding(top = 32.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Smart Parking"
        )
    }

    val ui = viewModel.uiState.collectAsState().value
    Log.e("smart_ui",ui.toString())
    if (!ui.isLoading) {
        if (!ui.isLogged) {
            onNavigateToLogin.invoke()
        } else if (!ui.isSignedUp) {
            onNavigateToSignUp.invoke()
        }
    }

}

