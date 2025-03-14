package com.bsoft.fruitier_native.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.bsoft.fruitier_native.R
import com.bsoft.fruitier_native.ui.pages.home.Explore
import com.bsoft.fruitier_native.ui.pages.home.Orders
import com.bsoft.fruitier_native.ui.pages.home.Settings
import com.bsoft.fruitier_native.ui.pages.home.WishList
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme

enum class AdaptiveDestinations(val title: String, val icon: Int){
    Explore(title = "Explore", icon = R.drawable.twotone_shopping_cart_24),
    WishList(title = "Wishlist", icon = R.drawable.twotone_favorite_24),
    Orders(title = "Orders", icon = R.drawable.twotone_delivery_dining_24),
    Settings(title = "Settings", icon = R.drawable.twotone_settings_24)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(){
    var currentDestination by rememberSaveable { mutableStateOf(AdaptiveDestinations.Explore) }

    val colors = NavigationSuiteDefaults.itemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    )

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AdaptiveDestinations.entries.forEach {
                item(onClick = { currentDestination = it },
                    icon = { Icon(imageVector = ImageVector.vectorResource(it.icon), contentDescription = "") },
                    label = { Text(text = it.title) },
                    colors = colors,
                    selected = it.title == currentDestination.title)
            }
        }
    ) {
        Scaffold (
            topBar = {
                TopAppBar( title = { Text(currentDestination.title, color = MaterialTheme.colorScheme.onPrimary) }, colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary))
            }
        ){
            Surface(modifier = Modifier.padding(paddingValues = it)) {
                when(currentDestination){
                    AdaptiveDestinations.Explore -> Explore()
                    AdaptiveDestinations.WishList -> WishList()
                    AdaptiveDestinations.Orders -> Orders()
                    AdaptiveDestinations.Settings -> Settings()
                }
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun HomePreview(){
    FruitierNativeTheme {
        Home()
    }
}