package com.bsoft.fruitier_native.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class User(val name: String, val surname: String, val email: String)

data class AuthState(
    val user: User? = null,
    val loading: Boolean = false,
    val message: String = "",
    val error: Throwable? = null,
    val isError: Boolean = false
)

@HiltViewModel
class AuthViewModel @Inject constructor(): ViewModel(){
    private val mutableState: MutableStateFlow<AuthState> = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = mutableState.asStateFlow()
}