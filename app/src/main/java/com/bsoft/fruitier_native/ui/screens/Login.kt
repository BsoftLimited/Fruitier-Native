package com.bsoft.fruitier_native.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme

@Composable
fun Login(){
    Surface (modifier = Modifier.fillMaxSize()) {
        Text("dvfjvf")
    }
}

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun LoginPreview(){
    FruitierNativeTheme {
        Login()
    }
}