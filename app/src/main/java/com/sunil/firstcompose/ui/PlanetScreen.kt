package com.sunil.firstcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sunil.firstcompose.ui.theme.FirstComposeTheme

@Composable
fun PlanetScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = ColorPainter(Color(0xFF4A2A0A)),
            contentDescription = "Main Planet",
            modifier = Modifier
                .size(600.dp)
                .offset(x = (-300).dp, y = (-100).dp)
                .clip(CircleShape)
        )
        Box(
            modifier = Modifier
                .size(600.dp)
                .offset(x = (-300).dp, y = (-100).dp)
                .clip(CircleShape)
                .background(Color(0x9900FF00))
        )
        Image(
            painter = ColorPainter(Color(0xFFD4BF4A)),
            contentDescription = "Small Planet",
            modifier = Modifier
                .size(80.dp)
                .offset(x = 100.dp, y = 500.dp)
                .clip(CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlanetScreenPreview() {
    FirstComposeTheme {
        PlanetScreen()
    }
}
