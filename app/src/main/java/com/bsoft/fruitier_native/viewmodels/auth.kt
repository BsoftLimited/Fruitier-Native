package com.bsoft.fruitier_native.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject



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

    fun login(email: String, password: String ){
        mutableState.value = AuthState(loading = true)

        auth.signInWith(Email){
            email = email
            password = password
        }.onSuccess {
            mutableState.value = AuthState(user = it.user)
        }
    }
}