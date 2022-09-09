package com.msg.presentation.ui.theme

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.msg.presentation.R

@Composable
fun ButtonText(text: String) {
    val font = FontFamily(Font(R.font.sfpro, FontWeight.Bold))
    Text(
        text = text,
        style = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.White
        )
    )
}

@Composable
fun DefaultText(text: String, fontSize: Int, textColor: Color = Color.White, modifier: Modifier = Modifier) {
    val font = FontFamily(Font(R.font.sfpro, FontWeight.Bold))
    Text(
        text = text,
        style = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize.sp,
            color = textColor
        ),
        modifier = modifier
    )
}