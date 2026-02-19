package com.sunil.firstcompose.listLayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sunil.firstcompose.R
import com.sunil.firstcompose.data.Quote

@Composable
fun QuoteListScreen(data : Array<Quote>, listState: LazyListState, onClick: (Quote) -> Unit) {
    Column() {
        Text("Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp, 24.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily(Font(R.font.roboto_bold))
        )

        QuoteList(data, listState = listState, onClick)
    }
}

