package com.msg.presentation.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.*

@Composable
fun LoginScreen(back: () -> Unit) {
    var email by remember { mutableStateOf<String?>(null) }
    var password by remember { mutableStateOf<String?>(null) }
    Background()
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier
                    .size(44.dp)
                    .clickable {
                        back()
                    },
                tint = Color.White
            )
            Text(text = "로그인", color = Color.White)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "이메일", color = Color.White, modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(4.dp))
        TextFieldNormal(text = email ?: "", textChange = { email = it }, "이메일을 입력해 주세요.")
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "비밀번호", color = Color.White, modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(4.dp))
        TextFieldNormal(text = password ?: "", textChange = { password = it }, "비밀번호를 입력해 주세요.")
        Spacer(modifier = Modifier.weight(1f))
        ButtonDisable(
            onClick = { },
            text = "로그인",
            gradient = Brush.linearGradient(BtnGradientPurple),
            enabledGradient = Brush.linearGradient(
                BtnGradientGray
            ),
            enabled = email.isNullOrBlank() || password.isNullOrBlank()
        )
        Spacer(modifier = Modifier.height(13.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "비밀번호 찾기", color = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "|", color = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "회원가입", color = Color.White)
        }
        Spacer(modifier = Modifier.height(17.dp))
    }
}