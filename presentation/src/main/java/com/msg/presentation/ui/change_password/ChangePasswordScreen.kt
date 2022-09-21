package com.msg.presentation.ui.change_password

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.*
import com.msg.presentation.R

@Composable
fun ChangePasswordScreen(back: () -> Unit, toLogin: () -> Unit) {
    Background()
    var password by remember { mutableStateOf<String?>(null) }
    var confirmPassword by remember { mutableStateOf<String?>(null) }
    var visiblePassword by remember { mutableStateOf<Boolean>(false) }
    var visibleConfirmPassword by remember { mutableStateOf<Boolean>(false) }
    var isError by remember { mutableStateOf(false) }
    fun confirmPassword() {
        if (password.equals(confirmPassword)) {
            toLogin()
        } else {
            isError = true
        }
    }
    Column {
        TookAppBar(back = { back() }, title = R.string.re_password)
        TextFieldNormal(
            label = R.string.new_password,
            text = password,
            textChange = { password = it; isError = false },
            placeholder = R.string.write_new_password,
            isError = isError,
            visible = visiblePassword,
            visibleIcon = R.drawable.ic_visible,
            unVisibleIcon = R.drawable.ic_unvisible,
            iconClick = { visiblePassword = !visiblePassword },
            keyboardType = KeyboardType.Password
        )
        TextFieldNormal(
            label = null,
            topMargin = 8,
            text = confirmPassword,
            textChange = { confirmPassword = it; isError = false },
            placeholder = R.string.write_confirm_password,
            isError = isError,
            visible = visibleConfirmPassword,
            visibleIcon = R.drawable.ic_visible,
            unVisibleIcon = R.drawable.ic_unvisible,
            iconClick = { visibleConfirmPassword = !visibleConfirmPassword },
            keyboardType = KeyboardType.Password
        )
        ErrorText(isError = isError, errorMsg = R.string.wrong_confirm_password)
        Spacer(modifier = Modifier.weight(1f))
        ButtonDisable(
            onClick = { confirmPassword() },
            text = R.string.okay,
            enabled = !password.isNullOrBlank() && !confirmPassword.isNullOrBlank()
        )
        Spacer(modifier = Modifier.height(45.dp))
    }
}