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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msg.presentation.R
import com.msg.presentation.ui.theme.*

@Composable
fun LoginScreen(back: () -> Unit) {
    var email by remember { mutableStateOf<String?>(null) }
    var password by remember { mutableStateOf<String?>(null) }
    Background()
    Column {
        Box(
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
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(id = R.string.login), color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = stringResource(id = R.string.email), color = Color.White, modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(4.dp))
        TextFieldNormal(text = email ?: "", textChange = { email = it }, stringResource(id = R.string.write_email))
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.password), color = Color.White, modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(4.dp))
        TextFieldNormal(text = password ?: "", textChange = { password = it }, stringResource(id = R.string.write_password))
        Spacer(modifier = Modifier.weight(1f))
        ButtonDisable(
            onClick = { },
            text = stringResource(id = R.string.login),
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
            Text(text = stringResource(id = R.string.find_password), color = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "|", color = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = stringResource(id = R.string.registration), color = Color.White)
        }
        Spacer(modifier = Modifier.height(17.dp))
    }
}