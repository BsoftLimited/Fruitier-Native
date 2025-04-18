package com.bsoft.fruitier_native.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.bsoft.fruitier_native.R

/*private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)*/

private data class Fonts(
    val acme: FontFamily = FontFamily(
        Font(R.font.acme_regular, FontWeight.Normal)
    )
)

private val LocalFontsProvider = compositionLocalOf <Fonts>{
    error("No Fonts Provider found!")
}

@Composable
fun FontsProviderWrapper(content: @Composable () -> Unit){
    val fonts = Fonts()

    CompositionLocalProvider(LocalFontsProvider provides fonts) {
        content()
    }
}

object FontsProvider{
    val acme: FontFamily @Composable @ReadOnlyComposable get() = LocalFontsProvider.current.acme
}