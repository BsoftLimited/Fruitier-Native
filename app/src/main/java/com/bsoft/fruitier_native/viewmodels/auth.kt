package com.bsoft.fruitier_native.viewmodels

import androidx.lifecycle.ViewModel
import com.bsoft.fruitier_native.models.Account
import com.bsoft.fruitier_native.utils.Repository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AuthState(
    val account: Account? = null,
    val loading: Boolean = false,
    val message: String = "",
    val error: Throwable? = null,
    val isError: Boolean = false
)

class AuthViewModel(val repository: Repository): ViewModel(){
    private val mutableState: MutableStateFlow<AuthState> = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = mutableState.asStateFlow()

    fun login(email: String, password: String ){
        mutableState.value = AuthState(loading = true)


    }
}