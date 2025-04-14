package com.bsoft.fruitier_native.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.bsoft.fruitier_native.R
import com.bsoft.fruitier_native.ui.components.NavigationExplore
import com.bsoft.fruitier_native.ui.pages.home.Explore
import com.bsoft.fruitier_native.ui.pages.home.Orders
import com.bsoft.fruitier_native.ui.pages.home.Settings
import com.bsoft.fruitier_native.ui.pages.home.WishList
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme
import com.bsoft.fruitier_native.utils.MobilePreview
import com.bsoft.fruitier_native.viewmodels.AuthViewModel
import com.bsoft.fruitier_native.viewmodels.SettingsViewModel

enum class AdaptiveDestinations(val title: String, val icon: Int){
    Explore(title = "Explore", icon = R.drawable.twotone_shopping_cart_24),
    WishList(title = "Wishlist", icon = R.drawable.twotone_favorite_24),
    Orders(title = "Orders", icon = R.drawable.twotone_delivery_dining_24),
    Settings(title = "Settings", icon = R.drawable.twotone_settings_24)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(currentDestination: AdaptiveDestinations){
    val colors = TopAppBarDefaults.topAppBarColors(
        titleContentColor = MaterialTheme.colorScheme.onPrimary,
        containerColor = MaterialTheme.colorScheme.primary)
    if(currentDestination.title != AdaptiveDestinations.Explore.title){
        TopAppBar(title = { Text(currentDestination.title) }, colors = colors)
    }
}

@Composable
fun Home(authViewModel: AuthViewModel? = null, settingsViewModel: SettingsViewModel? = null){
    var currentDestination by remember { mutableStateOf(AdaptiveDestinations.Explore) }

    val colors = NavigationSuiteDefaults.itemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.Transparent,
            selectedIconColor = MaterialTheme.colorScheme.primary,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    )

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AdaptiveDestinations.entries.forEach {
                if (it.title == AdaptiveDestinations.Explore.title){
                    item(onClick = { currentDestination = it },
                        icon = {
                            NavigationExplore(R.drawable.twotone_shopping_cart_24, active = it.title == currentDestination.title)
                        },
                        colors = colors,
                        alwaysShowLabel = false,
                        selected = it.title == currentDestination.title)
                }  else {
                    item(onClick = { currentDestination = it },
                        modifier = Modifier.padding(4.dp),
                        icon = { Icon(imageVector = ImageVector.vectorResource(it.icon), contentDescription = "") },
                        label = { Text(text = it.title) },
                        colors = colors,
                        selected = it.title == currentDestination.title)
                }
            }
        }) {
        Scaffold (topBar = { HomeTopBar(currentDestination) }){
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

@MobilePreview
@Composable
fun HomePreview(){
    FruitierNativeTheme {
        Home()
    }
}