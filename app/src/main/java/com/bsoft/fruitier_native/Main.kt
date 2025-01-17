package com.bsoft.fruitier_native

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bsoft.fruitier_native.screens.Home
import com.bsoft.fruitier_native.screens.Splash
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun Main(){
    FruitierNativeTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            val navController = rememberNavController()

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