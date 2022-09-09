package com.msg.presentation.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
            color = White1
        )
    )
}

@Composable
fun DefaultText(text: String, fontSize: Int, textColor: Color = White1, modifier: Modifier = Modifier) {
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

@Composable
fun ErrorText(isError: Boolean, errorMsg: Int) {
    if (isError) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp)
                .height(28.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ErrorOutline,
                contentDescription = null,
                tint = Red
            )
            DefaultText(
                text = stringResource(id = errorMsg),
                fontSize = 12,
                textColor = Red,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}