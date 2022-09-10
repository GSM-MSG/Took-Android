package com.msg.presentation.ui.confirm

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.msg.presentation.R
import com.msg.presentation.ui.theme.Background
import com.msg.presentation.ui.theme.TookAppBar

@Composable
fun ConfirmScreen(back: () -> Unit) {
    Background()
    Column {
        TookAppBar(back = { back() }, title = R.string.confirm)
    }
}