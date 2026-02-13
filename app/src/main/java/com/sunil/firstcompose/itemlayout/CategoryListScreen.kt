package com.sunil.firstcompose.itemlayout


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sunil.firstcompose.data.getCategoryList
import com.sunil.firstcompose.list.BlogCategory


@Composable
fun CategoryListScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
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











