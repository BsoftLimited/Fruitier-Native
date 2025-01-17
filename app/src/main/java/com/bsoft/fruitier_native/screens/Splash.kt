package com.bsoft.fruitier_native.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsoft.fruitier_native.pages.SplashDefaulth
import com.bsoft.fruitier_native.pages.SplashSlider
import com.bsoft.fruitier_native.services.SettingsModel
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme

@Composable
fun Splash(settingModel: SettingsModel = viewModel()){
    val settingState by settingModel.data.collectAsState()

    if(settingState.user == null){
        SplashSlider()
    }else{
        SplashDefaulth()
    }
}

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun SplashPreview(settingModel: SettingsModel = viewModel()){
    FruitierNativeTheme {
        Splash()
    }
}