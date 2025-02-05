package com.bsoft.fruitier_native.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.bsoft.fruitier_native.LocalNavController
import com.bsoft.fruitier_native.R

class ShowCase(val image: Int, val title: String);

@Preview(showBackground = true, device = "id:pixel_8")
@Composable
fun SplashSlider(){
    val navController = LocalNavController.current

    val images = listOf(
        ShowCase(R.drawable.fashion_shop_rafiki_1, "Choose Products"),
        ShowCase(R.drawable.sales_consulting_pana_1, "Make Payment"),
        ShowCase(R.drawable.shopping_bag_rafiki_1, "Get your Order"))
    var current by remember { mutableIntStateOf(0) };

    fun next(){
        if(current < images.size - 1){
            current+= 1;
        }else{
            navController.navigate("home")
        }
    }

    fun prev(){
        if(current > 0){
            current -= 1;
        }
    }

    Column( horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Row {
                Text("${current + 1}", fontSize = TextUnit(20f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold)
                Text("/${images.size}", fontSize = TextUnit(20f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold)
            }
            TextButton(onClick = {}) {
                Text("Skip", fontSize = TextUnit(18f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            }
        }
        Column(modifier = Modifier.weight(weight = 1f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Image(imageVector = ImageVector.vectorResource(images[current].image), contentDescription = "")
            Text(images[current].title, fontWeight = FontWeight.ExtraBold, color = Color.Gray, fontSize = TextUnit(35f, type = TextUnitType.Sp))
            Spacer(Modifier.height(18.dp))
            Text(text = stringResource(R.string.splash_one), fontSize = TextUnit(20f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold, color = Color.LightGray)
        }
        Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()){
            TextButton(onClick = { prev() }) {
                Text("prev", color = Color.Gray, fontSize = TextUnit(18f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold)
            }
            Row(horizontalArrangement = Arrangement.Center) {
                val firstDot =  if(current == 0 ) { 50.dp } else { 10.dp };
                val secondDot =  if(current == 1 ) { 50.dp } else { 10.dp };
                val thirdDot =  if(current == 2 ) { 50.dp } else { 10.dp };

                Surface( color = Color.DarkGray,  shape = RoundedCornerShape(3.dp), modifier = Modifier.size(width = firstDot, height = 6.dp)){}
                Spacer(modifier = Modifier.width(10.dp))
                Surface( color = Color.DarkGray,  shape = RoundedCornerShape(3.dp), modifier = Modifier.size(width = secondDot, height = 6.dp)){}
                Spacer(modifier = Modifier.width(10.dp))
                Surface( color = Color.DarkGray,  shape = RoundedCornerShape(3.dp), modifier = Modifier.size(width = thirdDot, height = 6.dp)){}
            }
            TextButton(onClick = { next() }) {
                Text("next", color = MaterialTheme.colorScheme.primary, fontSize = TextUnit(18f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold)
            }
        }
    }
}