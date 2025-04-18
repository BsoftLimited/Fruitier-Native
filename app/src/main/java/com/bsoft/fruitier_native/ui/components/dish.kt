package com.bsoft.fruitier_native.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoft.fruitier_native.R
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme
import com.bsoft.fruitier_native.utils.FontsProvider
import com.bsoft.fruitier_native.utils.FontsProviderWrapper
import com.bsoft.fruitier_native.utils.MobilePreview

@Composable
fun DishView(){
    Surface(color = MaterialTheme.colorScheme.surfaceContainerHighest, shape = RoundedCornerShape(16.dp)){
        Box(modifier = Modifier.padding(14.dp)){
            Column(modifier = Modifier.width(150.dp).align(Alignment.Center), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    modifier = Modifier.size(80.dp),
                    contentDescription = "",
                    bitmap = ImageBitmap.imageResource(R.drawable.honey_sample)
                )
                Text("Honey lime combo", fontFamily = FontsProvider.acme, fontSize = 16.sp)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "\u20A6 5,000", fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
                    Box(
                        modifier = Modifier.size(26.dp).clip(shape = CircleShape).background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center){
                        Text("+", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
                    }
                }
            }
            Icon(modifier = Modifier.size(20.dp).align(Alignment.TopEnd),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = "",
                imageVector = ImageVector.vectorResource(R.drawable.heart)
            )
        }
    }
}

@MobilePreview
@Composable
fun DishViewPreview(){
    FruitierNativeTheme {
        FontsProviderWrapper {
            DishView()
        }
    }
}