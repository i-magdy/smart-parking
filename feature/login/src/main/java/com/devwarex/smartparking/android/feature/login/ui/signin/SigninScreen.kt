package com.devwarex.smartparking.android.feature.login.ui.signin

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devwarex.smartparking.android.core.common.util.VerifyUiError
import com.devwarex.smartparking.android.ui.R
import com.google.firebase.auth.PhoneAuthOptions


@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    phoneServiceBuilder: PhoneAuthOptions.Builder,
    viewModel: SignInViewModel = hiltViewModel(),
    onNavigateToSignUp: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = ScrollState(0))
    ) {
        viewModel.init(phoneServiceBuilder)

        Text(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            color = MaterialTheme.colorScheme.primary,
            text = stringResource(id = R.string.app_name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = stringResource(id = R.string.verify_message),
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(16.dp))

        Row(
            Modifier
                .fillMaxSize()
                .wrapContentHeight()) {

            Text(
                text = "EG +2",
                modifier = modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            VerifyPhoneNumberTextField()
        }

        Spacer(modifier = modifier.height(16.dp))
        
        val uiState = viewModel.uiState.collectAsState().value
        if (uiState.isSuccess){
            onNavigateToSignUp.invoke()
        }
        if (uiState.phone.isNotEmpty() && !uiState.isCodeSent){
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { viewModel.requestCode() }
            ) {
                Text(text = stringResource(id = R.string.get_verify_title))
            }
        }
        if (uiState.isCodeSent){
            VerificationCodeTextField()
        }

        if (uiState.code.length == 6){
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { viewModel.verify() }
            ) {
                Text(text = stringResource(id = R.string.verify_title))
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyPhoneNumberTextField(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
){
    val uiState = viewModel.uiState.collectAsState().value
    OutlinedTextField(
        value = uiState.phone,
        onValueChange = viewModel::setPhone,
        singleLine = true,
        enabled = !uiState.isCodeSent && !uiState.isVerifying && !uiState.isSuccess,
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 16.dp, start = 16.dp),
        label = { Text(text = stringResource(id = R.string.phone_title)) },
        placeholder = { Text(text = stringResource(id = R.string.phone_title)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        supportingText = {

        },
        isError = uiState.error != VerifyUiError.NONE
    )
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationCodeTextField(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
){
    val uiState = viewModel.uiState.collectAsState().value
    OutlinedTextField(
        value = uiState.code,
        onValueChange = viewModel::setCode,
        singleLine = true,
        enabled = uiState.isCodeSent && !uiState.isVerifying && !uiState.isSuccess,
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 16.dp, start = 16.dp),
        label = { Text(text = stringResource(id = R.string.code_title)) },
        placeholder = { Text(text = stringResource(id = R.string.code_title)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        supportingText = {

        },
        isError = uiState.error != VerifyUiError.NONE
    )
}