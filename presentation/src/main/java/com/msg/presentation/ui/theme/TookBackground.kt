package com.msg.presentation.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.msg.presentation.R

@Composable
fun TookBackground() {
    Row(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.ic_bg_blur),
            contentDescription = "blur",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}