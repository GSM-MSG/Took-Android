package com.msg.presentation.ui.card_sotrage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardDetailPage(url: String, back: () -> Unit) {

    Icon(
        imageVector = Icons.Rounded.ArrowBackIos,
        contentDescription = null,
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                back()
            },
        tint = Color.White
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(Color.White)
                .width(312.dp)
                .height(516.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = url)
        }
    }
}