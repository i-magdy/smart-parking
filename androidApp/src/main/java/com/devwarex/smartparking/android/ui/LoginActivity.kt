package com.devwarex.smartparking.android.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.devwarex.smartparking.android.navigation.LoginNavHost
import com.devwarex.smartparking.android.theme.SmartParkingTheme
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  builder = PhoneAuthOptions.newBuilder(Firebase.auth).setActivity(this)
        setContent {
            SmartParkingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginNavHost(
                        phoneServiceBuilder = builder
                    )
                }
            }
        }
    }
}