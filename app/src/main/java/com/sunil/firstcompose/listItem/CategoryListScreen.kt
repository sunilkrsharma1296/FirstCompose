package com.sunil.firstcompose.listItem

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sunil.firstcompose.data.getCategoryList

@Composable
fun CategoryListScreen() {
    LazyColumn(
        modifier = Modifier.Companion.fillMaxSize()
    ) {
        items(getCategoryList()) { item ->
            BlogCategory(
                imgId = item.imgId,
                title = item.title,
                subtitle = item.subtitle
            )
        }
    }
}