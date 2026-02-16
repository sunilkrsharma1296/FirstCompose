package com.sunil.firstcompose.itemlayout

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sunil.firstcompose.data.Quote
import com.sunil.firstcompose.list.QuoteListItem

@Composable
fun QuoteList(data : Array<Quote>,
              listState: LazyListState,
              onClick: (Quote) -> Unit) {
    LazyColumn(state = listState) {
        items(data) { quote ->
            QuoteListItem(quote){
                onClick(quote)
            }
        }

    }
}