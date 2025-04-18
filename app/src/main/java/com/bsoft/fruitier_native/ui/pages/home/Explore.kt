package com.bsoft.fruitier_native.ui.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoft.fruitier_native.R
import com.bsoft.fruitier_native.ui.components.CategoriesSelectView
import com.bsoft.fruitier_native.ui.components.DishView
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme
import com.bsoft.fruitier_native.utils.FontsProvider
import com.bsoft.fruitier_native.utils.FontsProviderWrapper
import com.bsoft.fruitier_native.utils.MobilePreview

@Composable
fun Explore(modifier: Modifier = Modifier){
    val pageScrollState: ScrollState = rememberScrollState()
    val recommendedScrollState: ScrollState = rememberScrollState()
    val categoryScrollState: ScrollState = rememberScrollState()

    val categories = listOf("Hottest", "Popular", "New Combo", "Top")

    var currentCategory  by remember { mutableStateOf(categories.first()) }

    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier.verticalScroll(state = pageScrollState, enabled = true).padding(vertical = 20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)){
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom){
                IconButton(onClick = {}) {
                    Icon(
                        modifier = Modifier.size(60.dp),
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
                        Text("My Basket", color = MaterialTheme.colorScheme.onSurface, fontSize = 12.sp, fontFamily = FontsProvider.acme)
                    }
                }
            }
            Text( modifier = Modifier.width(300.dp).padding(horizontal = 20.dp), fontFamily = FontsProvider.acme, text = "Hello Tony, What fruit salad combo do you want today?", fontSize = 20.sp)
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                IconButton(modifier = Modifier.background(color = MaterialTheme.colorScheme.surfaceContainerHigh, shape = CircleShape), onClick = {}) {
                    Icon(
                        contentDescription = "",
                        imageVector = ImageVector.vectorResource(R.drawable.baseline_search_24))
                }
                Icon(
                    modifier = Modifier.size(30.dp),
                    contentDescription = "",
                    imageVector = ImageVector.vectorResource(R.drawable.filter)
                )
            }
            Text("Recommended Combo", modifier = Modifier.padding(horizontal = 20.dp), fontFamily = FontsProvider.acme, fontSize = 24.sp)
            Row(modifier = Modifier.horizontalScroll(state = recommendedScrollState, enabled = true).padding(horizontal = 20.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)){
                repeat((0..6).count()) {
                    DishView()
                }
            }
            CategoriesSelectView(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), categories = categories, current =  currentCategory) {
                currentCategory = it
            }
            Row(modifier = Modifier.horizontalScroll(state = categoryScrollState, enabled = true).padding(horizontal = 20.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)){
                repeat((0..6).count()) {
                    DishView()
                }
            }
        }
    }
}

@MobilePreview
@Composable
fun ExplorePreview(){
    FruitierNativeTheme {
        FontsProviderWrapper {
            Explore()
        }
    }
}