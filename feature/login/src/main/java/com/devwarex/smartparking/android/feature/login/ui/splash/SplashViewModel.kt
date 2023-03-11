package com.devwarex.smartparking.android.feature.login.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devwarex.smartparking.android.core.data.repository.CurrentUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val currentUserRepository: CurrentUserRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(SplashUiState())
    var uiState: StateFlow<SplashUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLogged = currentUserRepository.isUserLogged()
                )
            }
        }
    }
}