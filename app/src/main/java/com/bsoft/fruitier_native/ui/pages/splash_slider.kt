package com.bsoft.fruitier_native.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsoft.fruitier_native.R
import com.bsoft.fruitier_native.ui.components.Dashes
import com.bsoft.fruitier_native.ui.theme.FruitierNativeTheme
import com.bsoft.fruitier_native.utils.MobilePreview
import com.bsoft.fruitier_native.utils.customViewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ShowCase(val image: Int, val title: String)

private class ShowCaseViewModel(val size: Int): ViewModel(){
    private val mutableState: MutableStateFlow<Int> = MutableStateFlow(0)
    val index: StateFlow<Int> = mutableState.asStateFlow()

    fun next(done: () -> Unit){
        if(mutableState.value < size - 1){
            mutableState.value += 1
        }else{
            done()
        }
    }

    fun prev(){
        if(mutableState.value > 0){
            mutableState.value -= 1
        }
    }
}

@Composable
fun SplashSlider(done: ()-> Unit){
    val images = listOf(
        ShowCase(R.drawable.fashion_shop_rafiki_1, "Choose Products"),
        ShowCase(R.drawable.sales_consulting_pana_1, "Make Payment"),
        ShowCase(R.drawable.shopping_bag_rafiki_1, "Get your Order")
    )

    val showCaseViewModel: ShowCaseViewModel = viewModel(factory = customViewModelFactory {
        ShowCaseViewModel(size = images.size)
    })

    val current by showCaseViewModel.index.collectAsState()

    Scaffold { it ->
        Surface(modifier = Modifier.padding(it)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(20.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                    Row {
                        Text("${current + 1}", fontSize = TextUnit(18f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold)
                        Text("/${images.size}", fontSize = TextUnit(18f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold)
                    }
                    TextButton(onClick = done) {
                        Text(
                            "Skip",
                            fontSize = TextUnit(18f, type = TextUnitType.Sp),
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                Column(modifier = Modifier.weight(weight = 1f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(imageVector = ImageVector.vectorResource(images[current].image), contentDescription = "")
                    Text(
                        images[current].title,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Gray,
                        fontSize = TextUnit(30f, type = TextUnitType.Sp)
                    )
                    Spacer(Modifier.height(18.dp))
                    Text(
                        text = stringResource(R.string.splash_one),
                        fontSize = TextUnit(14f, type = TextUnitType.Sp),
                        fontWeight = FontWeight.Bold,
                        color = Color.LightGray
                    )
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    TextButton(onClick = { showCaseViewModel.prev() }) {
                        Text("Prev", color = Color.Gray, fontSize = TextUnit(18f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold)
                    }
                    Dashes(index = current, count = images.size)
                    TextButton(onClick = { showCaseViewModel.next(done = done) }) {
                        Text("Next", color = MaterialTheme.colorScheme.primary, fontSize = TextUnit(18f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@MobilePreview
@Composable
private fun SplashSliderPreview(){
    FruitierNativeTheme {
        SplashSlider{

        }
    }
}