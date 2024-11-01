package com.bsoft.fruitier_native.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bsoft.fruitier_native.R

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun SplashDefaulth(){
    Surface (modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center){
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.logo),
                contentDescription = "App Logo",
            )
        }
        Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.padding(all = 10.dp)){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator(strokeWidth = 2.dp)
                Spacer(Modifier.height(8.dp))
                Text("Loading, please wait ...")
            }
        }
    }
}