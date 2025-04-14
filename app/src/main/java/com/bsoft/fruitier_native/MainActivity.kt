package com.bsoft.fruitier_native

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bsoft.fruitier_native.ui.Main
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            FruitierNativeTheme {
                Main()
            }
        }
    }
}