package com.bsoft.fruitier_native.services

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class User(val name: String, val surname: String, val email: String);

data class SettingData(val user: User? = null);

class SettingsModel: ViewModel(){
     val __data: MutableStateFlow<SettingData> = MutableStateFlow(SettingData())
     val data: StateFlow<SettingData> = __data.asStateFlow()

     fun login(user: User){
          __data.update { SettingData(user) }
     }
}