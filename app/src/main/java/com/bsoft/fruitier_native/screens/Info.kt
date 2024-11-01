package com.bsoft.fruitier_native.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Info()
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun Info(){
    FruitierNativeTheme {
        Surface (modifier = Modifier.fillMaxSize()) {

        }
    }
}