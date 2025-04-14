package com.bsoft.fruitier_native.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme
import com.bsoft.fruitier_native.utils.MobilePreview
import com.bsoft.fruitier_native.viewmodels.AuthViewModel

@Composable
fun SignUp(authViewModel: AuthViewModel? = null){
    Surface (modifier = Modifier.fillMaxSize()) {

    }
}

@MobilePreview
@Composable
fun SignUpPreview(){
    FruitierNativeTheme {
        SignUp()
    }
}