package com.devwarex.smartparking.android.feature.login.ui.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devwarex.smartparking.android.core.data.repository.CurrentUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val currentUserRepository: CurrentUserRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(SignupUiState())
    val uiState: StateFlow<SignupUiState> = _uiState

    fun setName(name: String){
        _uiState.getAndUpdate {
            it.copy(name = name)
        }
    }

    fun signup() = viewModelScope.launch{

        Log.e("Smart_signup",currentUserRepository.signup(_uiState.value.name).toString())

    }

}