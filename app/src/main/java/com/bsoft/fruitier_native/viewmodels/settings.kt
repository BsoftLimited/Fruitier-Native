package com.bsoft.fruitier_native.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoft.fruitier_native.utils.DataStoreManager
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(private val dataStoreManager: DataStoreManager) : ViewModel() {
    // Expose the onboarding completion status as a StateFlow
    val isOnboardingCompleted = dataStoreManager.isOnboardingCompleted.stateIn(
        initialValue = null, scope = viewModelScope,
        started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(5000),
    )

    val themeMode = dataStoreManager.themeMode.stateIn(
        initialValue = "auto", scope = viewModelScope,
        started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(5000),
    )

    // Function to mark onboarding as completed
    fun markOnboardingCompleted() {
        viewModelScope.launch {
            dataStoreManager.saveOnboardingCompleted(true)
        }
    }

    fun setThemeMode(themeMode: String){
        viewModelScope.launch {
            dataStoreManager.changeThemeMode(themeMode)
        }
    }
}