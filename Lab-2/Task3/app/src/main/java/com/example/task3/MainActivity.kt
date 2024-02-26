package com.example.task3

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task3.ui.theme.Task3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task3Theme {
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
    Column {
        CreateRow(Img = R.drawable.ironman, name = "Iron Man", age = 43)
        CreateRow(Img = R.drawable.hulk, name = "Hulk", age = 38)
        CreateRow(Img = R.drawable.deadpool, name = "Deadpool", age = 25)
        CreateRow(Img = R.drawable.wolverine, name = "Wolverine", age = 48)
        CreateRow(Img = R.drawable.widow, name = "Black Widow", age = 30)
        CreateRow(Img = R.drawable.thor, name = "Thor", age = 35)
    }
}

@Composable
fun CreateRow(Img : Int, name : String, age : Int){
    Row(
        modifier = Modifier.height(120.dp).padding(10.dp)
    ) {
        Image(painter = painterResource(id = Img),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterVertically),
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "${name}", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Text(text = "Age : ${age}")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Task3Theme {
        Greeting("Android")
    }
}