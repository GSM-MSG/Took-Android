package com.msg.presentation.ui.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.msg.presentation.R
import com.msg.presentation.ui.theme.*

@Composable
fun SignUpScreen(back: () -> Unit, toLogin: () -> Unit) {
    Background()
    Column {
        TookAppBar(back = { back() }, title = R.string.registration)
        signUpField(toLogin = { toLogin() })
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun signUpField(toLogin: () -> Unit) {
    var email by remember { mutableStateOf<String?>(null) }
    var password by remember { mutableStateOf<String?>(null) }
    var visiblePassword by remember { mutableStateOf<Boolean>(false) }
    var isError by remember { mutableStateOf<Boolean>(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun isLogin() {
        keyboardController?.hide()
        isError = true
    }

    Column {
        TextFieldNormal(
            label = R.string.email,
            text = email ?: "",
            textChange = { email = it; isError = false },
            placeholder = R.string.write_email,
            isError = isError,
            iconClick = { email = null }
        )
        TextFieldNormal(
            label = R.string.password,
            labelTopMargin = 24,
            text = password ?: "",
            textChange = { password = it; isError = false },
            placeholder = R.string.write_password,
            isError = isError,
            onDone = { keyboardController?.hide() },
            iconClick = { visiblePassword = !visiblePassword },
            visible = visiblePassword,
            visibleIcon = R.drawable.ic_visible,
            unVisibleIcon = R.drawable.ic_unvisible,
            keyboardType = KeyboardType.Password
        )
        ErrorText(isError = isError, errorMsg = R.string.wrong_login)
        Spacer(modifier = Modifier.weight(1f))
        signUpBtn(
            isLogin = { isLogin() },
            email = email,
            password = password,
            toLogin = { toLogin() }
        )
    }
}

@Composable
fun signUpBtn(
    isLogin: () -> Unit,
    email: String?,
    password: String?,
    toLogin: () -> Unit
) {
    ButtonDisable(
        onClick = { isLogin() },
        text = stringResource(id = R.string.registration),
        enabled = email.isNullOrBlank() || password.isNullOrBlank()
    )
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 13.dp, bottom = 17.dp)
    ) {
        DefaultText(
            text = stringResource(id = R.string.is_account),
            fontSize = 12,
            textColor = Gray1
        )
        DefaultText(
            text = stringResource(id = R.string.login),
            fontSize = 12,
            textColor = Gray1,
            modifier = Modifier
                .padding(start = 4.dp)
                .clickable {
                toLogin()
            }
        )
    }
}