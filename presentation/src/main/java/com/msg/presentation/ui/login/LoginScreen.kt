package com.msg.presentation.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.msg.presentation.R
import com.msg.presentation.ui.theme.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(back: () -> Unit, toRegistration: () -> Unit) {
    var email by remember { mutableStateOf<String?>(null) }
    var password by remember { mutableStateOf<String?>(null) }
    var isError by remember { mutableStateOf<Boolean>(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    fun isLogin() {
        keyboardController?.hide()
        isError = true
    }
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                DefaultText(
                    text = stringResource(id = R.string.login),
                    fontSize = 17
                )
            }
        }
        DefaultText(
            text = stringResource(id = R.string.email),
            fontSize = 14,
            modifier = Modifier.padding(start = 16.dp, top = 32.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextFieldNormal(
            text = email ?: "",
            textChange = { email = it; isError = false },
            placeholder = stringResource(id = R.string.write_email),
            isError = isError,
            onDone = { focusRequester.requestFocus() },
            imeAction = ImeAction.Next
        )
        DefaultText(
            text = stringResource(id = R.string.password),
            fontSize = 14,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextFieldNormal(
            text = password ?: "",
            textChange = { password = it; isError = false },
            placeholder = stringResource(id = R.string.write_password),
            isError = isError,
            onDone = { keyboardController?.hide() },
            modifier = Modifier.focusRequester(focusRequester)
        )
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
                    tint = Color.Red
                )
                DefaultText(
                    text = stringResource(id = R.string.wrong_login),
                    fontSize = 12,
                    textColor = Color.Red,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ButtonDisable(
            onClick = { isLogin() },
            text = stringResource(id = R.string.login),
            gradient = Brush.linearGradient(BtnGradientPurple),
            enabledGradient = Brush.linearGradient(
                BtnGradientGray
            ),
            enabled = email.isNullOrBlank() || password.isNullOrBlank()
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 13.dp, bottom = 17.dp)
        ) {
            DefaultText(
                text = stringResource(id = R.string.find_password),
                fontSize = 12,
                textColor = Color.Gray
            )
            DefaultText(
                text = "|",
                fontSize = 12,
                textColor = Color.Gray,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            DefaultText(
                text = stringResource(id = R.string.registration),
                fontSize = 12,
                textColor = Color.Gray
            )
        }
    }
}