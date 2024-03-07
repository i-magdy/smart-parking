package com.devwarex.smartparking.android.feature.login.ui.signup

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devwarex.smartparking.android.ui.R

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    viewModel: SignupViewModel = hiltViewModel()
){

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = ScrollState(0))
    ) {
        UserNameTextField()
        
        Spacer(modifier = modifier.padding(top = 56.dp))
        
        Button(
            modifier = modifier.align(Alignment.CenterHorizontally),
            onClick = { viewModel.signup() }
        ) {

            Text(
                text = "Sign up",
                modifier = modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserNameTextField(
    modifier: Modifier = Modifier,
    viewModel: SignupViewModel = hiltViewModel()
){
    val uiState = viewModel.uiState.collectAsState().value
    OutlinedTextField(
        value = uiState.name,
        onValueChange = viewModel::setName,
        singleLine = true,
        enabled = true, 
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 16.dp, start = 16.dp),
        label = { Text(text = stringResource(id = R.string.phone_title)) },
        placeholder = { Text(text = stringResource(id = R.string.phone_title)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        supportingText = {

        },
        isError = false
    )
}