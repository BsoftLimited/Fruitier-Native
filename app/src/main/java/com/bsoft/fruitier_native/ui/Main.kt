package com.bsoft.fruitier_native.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bsoft.fruitier_native.FruitierApp
import com.bsoft.fruitier_native.ui.screens.Home
import com.bsoft.fruitier_native.ui.screens.Info
import com.bsoft.fruitier_native.ui.screens.Login
import com.bsoft.fruitier_native.ui.screens.SignUp
import com.bsoft.fruitier_native.ui.screens.Splash
import com.bsoft.fruitier_native.utils.FontsProviderWrapper
import com.bsoft.fruitier_native.utils.customViewModelFactory
import com.bsoft.fruitier_native.viewmodels.AuthViewModel
import com.bsoft.fruitier_native.viewmodels.SettingsViewModel

val LocalNavController = compositionLocalOf <NavController>{
    error("No NavController found!")
}

@Composable
fun Main(){
    val settingsViewModel: SettingsViewModel = viewModel(factory = customViewModelFactory {
        SettingsViewModel(dataStoreManager = FruitierApp.appModule.dataStoreManager)
    })

    val authViewModel: AuthViewModel = viewModel(factory = customViewModelFactory {
        AuthViewModel(repository = FruitierApp.appModule.repository)
    })

    Surface (modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()

        FontsProviderWrapper{
            CompositionLocalProvider(LocalNavController provides navController) {
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {
                        Splash(settingsViewModel = settingsViewModel, authViewModel = authViewModel)
                    }
                    composable("home"){
                        Home(settingsViewModel = settingsViewModel, authViewModel = authViewModel)
                    }
                    composable("info", content = { Info() })
                    composable("login"){
                        Login(authViewModel = authViewModel)
                    }
                    composable("signup"){
                        SignUp(authViewModel = authViewModel)
                    }
                }
            }
        }
    }
}