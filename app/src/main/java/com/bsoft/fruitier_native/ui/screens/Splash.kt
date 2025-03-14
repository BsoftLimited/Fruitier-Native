package com.bsoft.fruitier_native.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsoft.fruitier_native.ui.pages.SplashDefault
import com.bsoft.fruitier_native.ui.pages.SplashSlider
import com.bsoft.fruitier_native.viewmodels.SettingsModel
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme

@Composable
fun Splash(settingModel: SettingsModel = viewModel()){
    val settingState by settingModel.state.collectAsState()

    if(settingState.firstVisit){
        SplashSlider()
    }else{
        SplashDefault()
    }
}

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun SplashPreview(settingModel: SettingsModel = viewModel()){
    FruitierNativeTheme {
        Splash()
    }
}