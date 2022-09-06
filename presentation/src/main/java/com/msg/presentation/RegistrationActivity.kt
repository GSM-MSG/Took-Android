package com.msg.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.*

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Background()
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                TopBar()
                Spacer(modifier = Modifier.height(32.dp))
                AddCard()
                Spacer(modifier = Modifier.height(140.dp))
                RegisterBtn()
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Composable
fun RegisterBtn() {
    if (true) {
        ButtonGradient(
            onClick = { },
            text = "등록완료!",
            Brush.linearGradient(
                colors = BtnGradient,
            )
        )
    } else {
        ButtonNormal(
            onClick = { },
            text = "등록완료!",
            Color.Gray
        )
    }
}

@Composable
fun AddCard() {
    Column() {
        ButtonAddCard(
            onClick = { },
            text = "앞면 등록하기",
            uri = null
        )
        Spacer(modifier = Modifier.height(20.dp))
        ButtonAddCard(
            onClick = { },
            text = "뒷면 등록하기",
            uri = null
        )
    }
}

@Preview
@Composable
fun TopBar() {
    Box(modifier = Modifier.fillMaxWidth()) {
        IconButton(onClick = { }) {
            Icon(
                Icons.Default.ArrowBackIos,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            DefalutText(text = "명함 등록", 17)
        }

    }
}

