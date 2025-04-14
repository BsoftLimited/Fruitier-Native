package com.bsoft.fruitier_native.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.bsoft.fruitier_native.ui.LocalNavController
import com.bsoft.fruitier_native.ui.pages.SplashDefault
import com.bsoft.fruitier_native.ui.pages.SplashSlider
import com.bsoft.fruitier_native.viewmodels.AuthViewModel
import com.bsoft.fruitier_native.viewmodels.SettingsViewModel

@Composable
fun Splash(settingsViewModel: SettingsViewModel, authViewModel: AuthViewModel? = null){
    val isOnboardingCompleted by settingsViewModel.isOnboardingCompleted.collectAsState()

    val navController = LocalNavController.current

    fun toHome(){
        navController.navigate(route = "home"){
            popUpTo("splash") { inclusive = true } // Remove "splash" from the back stack
        }
    }

    if(isOnboardingCompleted == false){
        SplashSlider{
            settingsViewModel.markOnboardingCompleted()
            toHome()
        }
    }else if(isOnboardingCompleted == null){
        SplashDefault()
    }else{
        toHome()
    }
}