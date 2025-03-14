package com.bsoft.fruitier_native.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class SettingState(
     val themeMode: String = "auto",
     val firstVisit: Boolean = true,
)

@HiltViewModel
class SettingsModel @Inject constructor(savedStateHandle: SavedStateHandle): ViewModel(){
     val state: StateFlow<SettingState> = savedStateHandle.getStateFlow("settings", SettingState())
}