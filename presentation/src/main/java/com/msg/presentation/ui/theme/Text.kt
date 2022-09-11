package com.msg.presentation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msg.presentation.R

@Composable
fun ButtonText(text: Int) {
    val font = FontFamily(Font(R.font.sfpro, FontWeight.Bold))
    Text(
        text = stringResource(id = text),
        style = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = White1
        )
    )
}

@Composable
fun DefaultText(
    text: Int,
    fontSize: Int,
    textColor: Color = White1,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Left
) {
    val font = FontFamily(Font(R.font.sfpro, FontWeight.Bold))
    Text(
        text = stringResource(id = text),
        style = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize.sp,
            color = textColor
        ),
        modifier = modifier,
        textAlign = textAlign
    )
}

@Composable
fun BoxText(
    text: Int,
    modifier: Modifier,
    fontSize: Int,
    onClick: (Int) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clickable { onClick(text) },
        contentAlignment = Alignment.Center
    ) {
        DefaultText(
            text = text,
            fontSize = fontSize,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BoxNumerText(
    text: Int?,
    modifier: Modifier,
    fontSize: Int,
    current: Int,
    position: Int
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(Black4, RoundedCornerShape(16.dp))
            .border(1.dp, if (current == position) Purple2 else Black1, RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        if (text != null)
            DefaultText(
                text = text,
                fontSize = fontSize,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
    }
}

@Composable
fun ErrorText(
    isError: Boolean,
    errorMsg: Int,
    modifier: Modifier = Modifier
        .padding(start = 16.dp, top = 4.dp)
        .height(28.dp)
) {
    if (isError) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.ErrorOutline,
                contentDescription = null,
                tint = Red
            )
            DefaultText(
                text = errorMsg,
                fontSize = 12,
                textColor = Red,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}