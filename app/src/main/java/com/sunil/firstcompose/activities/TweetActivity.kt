package com.sunil.firstcompose.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sunil.firstcompose.listItem.TweetCategoryScreen
import com.sunil.firstcompose.listItem.TweetDetailScreen
import com.sunil.firstcompose.ui.theme.FirstComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TweetActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MainScreen()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars) // 🔥 THIS FIXES OVERLAP
        ) {
            FirstComposeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("FirstCompose") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Green
                            )
                        )
                    }
                ) { paddingValues ->
                    Box(Modifier.padding(paddingValues)) {
                        App()
                    }
                }

            }
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "category"){
            composable("category") {
                TweetCategoryScreen{
                    navController.navigate("detail/${it}")
                }
            }

            composable("detail/{category}",
                arguments = listOf(navArgument("category"){
                    type = NavType.StringType
                })
            ){
                TweetDetailScreen()
            }
        }
    }
}

