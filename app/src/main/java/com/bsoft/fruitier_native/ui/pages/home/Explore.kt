package com.bsoft.fruitier_native.ui.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoft.fruitier_native.R
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme
import com.bsoft.fruitier_native.utils.MobilePreview

@Composable
fun Explore(modifier: Modifier = Modifier){
    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier.padding(20.dp)){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom){
                IconButton(onClick = {}) {
                    Icon(
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = "",
                        imageVector = ImageVector.vectorResource(R.drawable.baseline_short_text_24))
                }
                Surface{
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp), horizontalAlignment = Alignment.CenterHorizontally){
                        Icon(
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "",
                            imageVector = ImageVector.vectorResource(R.drawable.fluent_emoji_high_contrast__basket))
                        Text("My Basket", color = MaterialTheme.colorScheme.onSurface, fontSize = 12.sp)
                    }
                }
            }
            Text( modifier = Modifier.width(250.dp), text = "Hello Tony, What fruit salad combo do you want today?", fontSize = 16.sp)
        }
    }
}

@MobilePreview
@Composable
fun ExplorePreview(){
    FruitierNativeTheme {
        Explore()
    }
}