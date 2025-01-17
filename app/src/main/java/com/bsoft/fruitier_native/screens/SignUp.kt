package com.bsoft.fruitier_native.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme

@Composable
fun SignUp(){
    Surface (modifier = Modifier.fillMaxSize()) {

    }
}

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun SignUpPreview(){
    FruitierNativeTheme {
        SignUp()
    }
}