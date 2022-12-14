package com.msg.presentation.ui.start

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.*
import com.msg.presentation.R

@Composable
fun StartScreen(
    toLogin: () -> Unit,
    toSignUp: () -> Unit
) {
    Background()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Transparent),
        verticalArrangement = Arrangement.Bottom,
    ) {
        ButtonGradient(
            onClick = { toSignUp() },
            text = R.string.registration,
            Brush.linearGradient(
                colors = GradientPurple,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        ButtonNormal(
            onClick = { toLogin() },
            text = R.string.login,
            bolder = BorderStroke(1.dp, White1)
        )
        Spacer(modifier = Modifier.height(44.dp))
    }
}