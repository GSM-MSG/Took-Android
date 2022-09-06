package com.msg.presentation.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
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
        ButtonText(text = text)
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
            ButtonText(text = text)
        }
    }
}

@Composable
fun ButtonDisable(
    onClick: () -> Unit,
    text: String,
    gradient: Brush,
    enabledGradient: Brush,
    enabled: Boolean
) {
    if(enabled) ButtonGradient(onClick = {  }, text = text, gradient = enabledGradient)
    else ButtonGradient(onClick = { onClick() }, text = text, gradient = gradient)
}

@Composable
fun ButtonAddCard(
    onClick: () -> Unit,
    text: String,
    uri: Uri?
) {
    if (uri == null) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(207.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray.copy(alpha = 0f),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(0.7.dp, Color.White)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.AddCircle, contentDescription = "")
                Spacer(modifier = Modifier.height(10.dp))
                ButtonText(text = text)
            }
        }
    } else {

    }
}

