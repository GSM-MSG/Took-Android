package com.msg.presentation.ui.start

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.Background
import com.msg.presentation.ui.theme.BtnGradientPurple
import com.msg.presentation.ui.theme.ButtonGradient
import com.msg.presentation.ui.theme.ButtonNormal

@Composable
fun StartScreen(
    toLogin: () -> Unit
) {
    Background()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Bottom,
    ) {
        ButtonGradient(
            onClick = { },
            text = "회원가입",
            Brush.linearGradient(
                colors = BtnGradientPurple,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        ButtonNormal(
            onClick = { toLogin() },
            text = "로그인",
            Color.Black,
            bolder = BorderStroke(1.dp, Color.White)
        )
        Spacer(modifier = Modifier.height(44.dp))
    }
}