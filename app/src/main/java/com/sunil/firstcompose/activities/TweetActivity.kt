package com.sunil.firstcompose.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sunil.firstcompose.api.TweetsyAPI
import com.sunil.firstcompose.listItem.CategoryListScreen
import com.sunil.firstcompose.listItem.TweetCategoryScreen
import com.sunil.firstcompose.listItem.TweetDetailScreen
import com.sunil.firstcompose.listLayout.NotificationScreen
import com.sunil.firstcompose.ui.theme.FirstComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TweetActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars) // 🔥 THIS FIXES OVERLAP
        ) {
            FirstComposeTheme {
                //TweetCategoryScreen()
                TweetDetailScreen()
            }
        }
    }
}

