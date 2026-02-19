package com.sunil.firstcompose.listItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.sunil.firstcompose.R
import com.sunil.firstcompose.data.Quote

@Composable
fun QuoteDetailScreen(quote: Quote) {
    Box(
        contentAlignment = Alignment.Companion.Center,
        modifier = Modifier.Companion
            .fillMaxSize(1f)
            .background(
                Brush.Companion.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.Companion.padding(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.Companion
                    .padding(16.dp, 24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    modifier = Modifier.Companion
                        .size(80.dp)
                        .rotate(180F)
                )

                Text(
                    quote.text,
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    modifier = Modifier.Companion.padding(0.dp, 0.dp, 0.dp, 2.dp)
                )

                Spacer(modifier = Modifier.Companion.padding(4.dp))

                Text(
                    quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),

                    )

            }
        }
    }

}