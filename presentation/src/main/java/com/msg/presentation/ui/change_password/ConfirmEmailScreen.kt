package com.msg.presentation.ui.change_password

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.*
import com.msg.presentation.R

@Composable
fun ConfirmEmailScreen(back: () -> Unit, toNext: () -> Unit) {
    Background()
    var email by remember { mutableStateOf<String?>(null) }
    var isError by remember { mutableStateOf(false) }
    fun confirmEmail() {
        if (email.equals("abcd")) {
            toNext()
        } else {
            isError = true
        }
    }
    Column {
        TookAppBar(back = { back() }, title = R.string.re_password)
        TextFieldNormal(
            label = R.string.email,
            text = email,
            textChange = { email = it; isError = false },
            placeholder = R.string.write_email,
            isError = isError,
            iconClick = { email = null })
        ErrorText(isError = isError, errorMsg = R.string.wrong_email)
        Spacer(modifier = Modifier.weight(1f))
        ButtonDisable(
            onClick = { confirmEmail() },
            text = R.string.okay,
            enabled = !email.isNullOrBlank()
        )
        Spacer(modifier = Modifier.height(45.dp))
    }
}