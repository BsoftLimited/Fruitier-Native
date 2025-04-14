package com.bsoft.fruitier_native.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.bsoft.fruitier_native.R
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme
import com.bsoft.fruitier_native.utils.MobilePreview

data class NavigationColors(val background: Color, val color: Color);

@Composable
fun NavigationExplore(@DrawableRes imageRes: Int, active: Boolean = false){
    val colors = if(active){
        NavigationColors(background = MaterialTheme.colorScheme.primary, color =  MaterialTheme.colorScheme.onPrimary)
    } else {
        NavigationColors(background = MaterialTheme.colorScheme.surface, color = MaterialTheme.colorScheme.onSurface)
    }

    Surface(shape = CircleShape, color = colors.background, shadowElevation = 4.dp){
        Icon(imageVector = ImageVector.vectorResource(imageRes), tint = colors.color, modifier = Modifier.size(60.dp).padding(12.dp), contentDescription = "")
    }
}

@MobilePreview
@Composable
fun NavigationExplorePreview(){
    FruitierNativeTheme {
        NavigationExplore(R.drawable.twotone_shopping_cart_24)
    }
}

@MobilePreview
@Composable
fun NavigationExploreActivePreview(){
    FruitierNativeTheme {
        NavigationExplore(R.drawable.twotone_shopping_cart_24, active = true)
    }
}