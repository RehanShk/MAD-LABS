package com.example.contentproviderassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contentproviderassignment.ui.theme.ContentProviderAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContentProviderAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JokeList()
                }
            }
        }
    }
}

@Composable
fun JokeList() {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Jokes", fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            JokeListItem(joke = "Why did the scarecrow win an award? Because he was outstanding in his field!")
        }
    }
}

@Composable
fun JokeListItem(joke: String) {
    Text(
        text = joke,
        fontSize = 18.sp,
        color = Color.Black
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JokeList()
}