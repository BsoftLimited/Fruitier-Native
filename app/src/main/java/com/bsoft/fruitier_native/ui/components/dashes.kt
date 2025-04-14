package com.bsoft.fruitier_native.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun Dash(active: Boolean = false){
    val width = if (active) { 50.dp } else { 6.dp }

    Surface(
        color = Color.DarkGray,
        shape = RoundedCornerShape(3.dp),
        modifier = Modifier.size(width = width, height = 6.dp),
        content = {}
    )
}

@Composable
fun Dashes(count: Int, index: Int){
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        (0..< count).map {
            Dash(active = index == it)
        }
    }
}

@Preview
@Composable
private fun DashesPreview(){
    Dashes(count = 3, index = 1)
}