package com.sunil.firstcompose.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sunil.firstcompose.data.Quote
import com.sunil.firstcompose.listItem.QuoteDetailScreen
import com.sunil.firstcompose.listLayout.QuoteListScreen
import com.sunil.firstcompose.models.DataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }



        setContent {
            MainScreen()
        }
    }


    @Composable
    fun MainScreen() {
        val selectedQuote = remember { mutableStateOf<Quote?>(null) }

        // 🔥 1. Add this to remember the scroll position
        val listState = rememberLazyListState()

        if (selectedQuote.value != null) {
            BackHandler {
                selectedQuote.value = null
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars) // 🔥 THIS FIXES OVERLAP
        ) {

            if (!DataManager.isDataLoaded.value) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("Loading...", style = MaterialTheme.typography.titleLarge)
                }
            } else {
                if (selectedQuote.value == null) {
                    //QuoteListScreen(data = DataManager.data) {}

                    QuoteListScreen(data = DataManager.data,
                        listState = listState) { quote ->
                        selectedQuote.value = quote
                    }

                } else {
                    if(selectedQuote.value!=null){
                        QuoteDetailScreen(quote = selectedQuote.value!!)
                    }

                }
            }
        }
    }


}