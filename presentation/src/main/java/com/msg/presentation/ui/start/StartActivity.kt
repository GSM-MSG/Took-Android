package com.msg.presentation.ui.start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.Background
import com.msg.presentation.ui.theme.BtnGradient
import com.msg.presentation.ui.theme.ButtonGradient
import com.msg.presentation.ui.theme.ButtonNormal

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                        colors =  BtnGradient,
                        )
                )
                Spacer(modifier = Modifier.height(16.dp))
                ButtonNormal(
                    onClick = { },
                    text = "로그인",
                    Color.Black,
                    bolder = BorderStroke(1.dp, Color.White)
                )
                Spacer(modifier = Modifier.height(44.dp))
            }
        }
    }
}