package com.sunil.firstcompose.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.sunil.firstcompose.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            EdgeToEdgeScreen()

            //TextInput()

            //PreviewFunction()


        }

    }

    @Composable
    fun EdgeToEdgeScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars) // 🔥 THIS FIXES OVERLAP
        ) {
            FirstScreen {
                startActivity(
                    Intent(this@MainActivity, HomeActivity::class.java)
                )
            }
        }
    }

    @Preview
    @Composable
    private fun PreviewFunction() {

        //TextInput()

        //RowColumnBox()

       // CircularImage()

        /*Column {
            ListViewItem(R.drawable.bg_1, "Sunil Sharma", "Software Developer")
            ListViewItem(R.drawable.bg_1, "Sunil Sharma", "Software Developer")
            ListViewItem(R.drawable.bg_1, "Sunil Sharma", "Software Developer")
            ListViewItem(R.drawable.bg_1, "Sunil Sharma", "Software Developer")
        }*/

    }


    @Composable
    fun ListViewItem(imagId: Int, name: String, occupation: String) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(imagId),
                contentDescription = "",
                Modifier.size(50.dp),
            )

            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = occupation,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Thin
                )

            }
        }
    }

    @Composable
    fun RowColumnBox() {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sunil",
                fontSize = 24.sp,
                color = Color.Green,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable { }
                    .background(Color.Blue)
                    .size(80.dp, 80.dp)
                    .padding(2.dp, 2.dp)
                    .border(2.dp, Color.Red, shape = CircleShape)
                    .clip(CircleShape)


            )
        }


        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "A", fontSize = 24.sp)
            Text(text = "C", fontSize = 24.sp)
        }

        Box(contentAlignment = Alignment.BottomEnd) {
            Row {
                Image(
                    painter = painterResource(
                        R.drawable.outline_agriculture_24
                    ), contentDescription = "", Modifier.size(50.dp)
                )
                Image(
                    painter = painterResource(
                        R.drawable.outline_ecg_heart_24
                    ), contentDescription = "", Modifier.size(50.dp)
                )
            }

        }
    }

    @Composable
    fun CircularImage() {

        Column() {
            Image(
                painter = painterResource(R.drawable.bg_2),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Red, CircleShape)
            )

            Button(onClick = {
                startActivity(Intent(this@MainActivity, HomeActivity::class.java))
            }) {
                Text(text = "Next")
                Modifier.padding(10.dp)
            }
        }

    }



    @Composable
    fun FirstScreen(onNextClick: () -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.bg_2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Red, CircleShape)
            )

            Spacer(modifier = Modifier.height(26.dp))

            Button(onClick = onNextClick) {
                Text(text = "Next")
            }
        }
    }



    @Composable
    fun TextInput() {
        val state = remember { mutableStateOf("") }

        TextField(
            value = state.value,
            onValueChange = {
                state.value = it

                Log.d("stateValue", state.value)
            },

            label = { Text(text = "Enter Message") },

            )
    }

}



