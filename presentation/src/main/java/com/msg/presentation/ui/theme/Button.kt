package com.msg.presentation.ui.theme

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ButtonNormal(
    onClick: () -> Unit,
    text: Int,
    buttonColor: Color = Transparent,
    bolder: BorderStroke? = null
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 0.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColor,
            contentColor = White1
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
    text: Int,
    gradient: Brush = Brush.linearGradient(GradientGray),
) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Transparent,
            contentColor = White1
        ),
        border = BorderStroke(0.dp, Transparent)
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
    text: Int,
    gradient: Brush = Brush.linearGradient(GradientPurple),
    enabled: Boolean
) {
    if(enabled) ButtonGradient(onClick = { onClick() }, text = text, gradient = gradient)
    else ButtonGradient(onClick = {  }, text = text)
}

@Composable
fun ButtonAddCard(
    onClick: () -> Unit,
    text: Int,
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
                backgroundColor = Black3,
                contentColor = White1
            ),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(0.5.dp, Gray5)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.AddCircle, contentDescription = "")
                Spacer(modifier = Modifier.height(10.dp))
                ButtonText(text = text)
            }
        }
    } else {
        GlideImage(
            imageModel = uri,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(207.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable(
                    enabled = true,
                    onClick = onClick
                )
        )
    }
}

