package com.bsoft.fruitier_native.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bsoft.fruitier_native.ui.screens.Home
import com.bsoft.fruitier_native.ui.screens.Splash
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme
import com.bsoft.fruitier_native.utils.MobilePreview

val LocalNavController = compositionLocalOf <NavController>{
    error("No NavController found!")
}

@Composable
fun Main(){
    FruitierNativeTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            val navController = rememberNavController()

            CompositionLocalProvider(LocalNavController provides navController) {
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {
                        Splash()
                    }
                    composable("home") {
                        Home()
                    }
                }
            }
        }
    }
}

@MobilePreview
@Composable
fun MainPreview(){
    Main()
}