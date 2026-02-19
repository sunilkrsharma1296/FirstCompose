package com.sunil.firstcompose.listItem


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sunil.firstcompose.viewmodel.DetailViewModel

@Composable
fun TweetDetailScreen(){
    val detailViewModel: DetailViewModel = viewModel()
    val tweets = detailViewModel.tweets.collectAsState()

    LazyColumn(content = {
        items(tweets.value) {
            TweetListItem(tweet = it.text)
        }
    })
}

@Composable
fun TweetListItem(tweet: String) {
    Card(
        Modifier.padding(8.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, Color.LightGray),
        content = {
            Text(
                text = tweet,
                modifier = Modifier.padding(16.dp),
                style = typography.bodyMedium
            )
        }
    )
}