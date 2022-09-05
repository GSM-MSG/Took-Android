package com.msg.presentation.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonNormal(
    onClick: () -> Unit,
    text: String,
    buttonColor: Color,
    bolder: BorderStroke? = null
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 0.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColor,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        border = bolder
    ) {
        Text(text = text)
    }
}

@Composable
fun ButtonGradient(
    onClick: () -> Unit,
    text: String,
    gradient: Brush,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(brush = gradient, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text)
        }
    }
}