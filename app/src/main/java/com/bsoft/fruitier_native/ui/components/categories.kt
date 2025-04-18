package com.bsoft.fruitier_native.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme
import com.bsoft.fruitier_native.utils.FontsProvider
import com.bsoft.fruitier_native.utils.FontsProviderWrapper
import com.bsoft.fruitier_native.utils.MobilePreview

@Composable
private fun CategorySelectView(name: String, selected: Boolean, onSelect: () -> Unit){
    val color = if(selected){ MaterialTheme.colorScheme.primary } else { Color.Transparent }
    Column(modifier = Modifier.clickable(enabled = true, onClick = onSelect)){
        Text(text = name, fontFamily = FontsProvider.acme, fontSize = 18.sp)
        Surface(modifier = Modifier.size(width = 25.dp, height = 2.dp), color = color){}
    }
}

@Composable
fun CategoriesSelectView(modifier: Modifier = Modifier, categories: List<String>, current: String, onChoose: (chosen: String)-> Unit){
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween){
        categories.map { name ->
            CategorySelectView(name = name, selected = name == current){
                onChoose(name)
            }
        }
    }
}

@MobilePreview
@Composable
private fun CategoriesSelectViewPreview(){
    val categories = listOf("Hottest", "Popular", "New Combo", "Top")

    var current  by remember { mutableStateOf(categories.first()) }

    FruitierNativeTheme {
        FontsProviderWrapper {
            Surface(modifier = Modifier.fillMaxWidth()){
                CategoriesSelectView(categories = categories, current =  current) { it -> current = it }
            }
        }
    }
}
