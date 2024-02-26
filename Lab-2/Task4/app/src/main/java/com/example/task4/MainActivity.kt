package com.example.task4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task4.ui.theme.Task4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            item{ CreateCard(cityName = "Hunza", cityImage = R.drawable.hunza)}
            item{ CreateCard(cityName = "Neelum", cityImage = R.drawable.picture2)}
            item{ CreateCard(cityName = "Gilgit", cityImage = R.drawable.picture3)}
            item{ CreateCard(cityName = "Murree", cityImage = R.drawable.picture4)}
            item{ CreateCard(cityName = "Naran", cityImage = R.drawable.picture5)}
            item{ CreateCard(cityName = "Kagan", cityImage = R.drawable.picture6)}
        }
    )
}

@Composable
fun CreateCard(cityName : String, cityImage : Int){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Color(160, 32, 240))
    ){
        Image(painter = painterResource(id = cityImage),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(text = "${cityName}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 5.dp),
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Task4Theme {
        Greeting("Android")
    }
}