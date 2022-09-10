package com.msg.presentation.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.zIndex
import com.msg.presentation.R

@Composable
fun Background() {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "background",
        modifier = Modifier.fillMaxWidth().background(Black2),
        contentScale = ContentScale.Crop
    )
}