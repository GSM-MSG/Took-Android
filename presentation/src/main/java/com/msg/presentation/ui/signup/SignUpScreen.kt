package com.msg.presentation.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.msg.presentation.R
import com.msg.presentation.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SignUpScreen(back: () -> Unit, toLogin: () -> Unit, toConfirm: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )
    val scope = rememberCoroutineScope()
    Background()
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetBackgroundColor = White1,
        sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        sheetContent = {
            bottomTerms(toConfirm = { toConfirm() })
        }) {
        Column {
            TookAppBar(back = { back() }, title = R.string.registration)
            signUpField(
                toLogin = { toLogin() },
                scope = scope,
                state = sheetState
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun signUpField(
    toLogin: () -> Unit,
    scope: CoroutineScope,
    state: ModalBottomSheetState
) {
    var email by remember { mutableStateOf<String?>(null) }
    var password by remember { mutableStateOf<String?>(null) }
    var visiblePassword by remember { mutableStateOf<Boolean>(false) }
    var isError by remember { mutableStateOf<Boolean>(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun isSignUp() {
        keyboardController?.hide()
        isError = true
        scope.launch {
            state.show()
        }
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
            isSignUp = { isSignUp() },
            email = email,
            password = password,
            toLogin = { toLogin() }
        )
    }
}

@Composable
fun signUpBtn(
    isSignUp: () -> Unit,
    email: String?,
    password: String?,
    toLogin: () -> Unit
) {
    ButtonDisable(
        onClick = { isSignUp() },
        text = R.string.registration,
        enabled = !email.isNullOrBlank() && !password.isNullOrBlank()
    )
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 13.dp, bottom = 17.dp)
    ) {
        DefaultText(
            text = R.string.is_account,
            fontSize = 12,
            textColor = Gray1
        )
        DefaultText(
            text = R.string.login,
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

@Composable
fun bottomTerms(toConfirm: () -> Unit) {
    var check1 by remember { mutableStateOf(false) }
    var check2 by remember { mutableStateOf(false) }
    var check3 by remember { mutableStateOf(false) }
    var check4 by remember { mutableStateOf(false) }
    var check5 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(480.dp)
    ) {
        DefaultText(
            text = R.string.agreed,
            fontSize = 20,
            textColor = Black2,
            modifier = Modifier.padding(start = 32.dp, top = 28.dp)
        )
        agreedCheckBox(
            enabled = check1 && check2 && check3 && check4 && check5, checkChange = {
                check1 = it; check2 = it; check3 = it; check4 = it; check5 = it
            }
        )
        divider()
        agreed(enabled = check1, checkChange = { check1 = it }, detailAgreed = {})
        agreed(enabled = check2, checkChange = { check2 = it }, detailAgreed = {})
        agreed(enabled = check3, checkChange = { check3 = it }, detailAgreed = {})
        agreed(enabled = check4, checkChange = { check4 = it }, detailAgreed = {})
        agreed(enabled = check5, checkChange = { check5 = it }, detailAgreed = {})
        Spacer(modifier = Modifier.weight(1f))
        ButtonDisable(
            onClick = { toConfirm() },
            text = R.string.okay,
            enabled = (check1 && check2 && check3 && check4 && check5)
        )
    }
}

@Composable
fun divider() {
    Box(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .fillMaxWidth()
            .height(1.dp)
            .background(White2)
    )
}