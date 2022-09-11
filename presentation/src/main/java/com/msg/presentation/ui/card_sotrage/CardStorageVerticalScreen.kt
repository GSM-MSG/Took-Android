package com.msg.presentation.ui.card_sotrage

import androidx.compose.runtime.Composable
import com.msg.presentation.ui.theme.CardStorageAppBar

@Composable
fun CardStorageVerticalScreen(toHorizental: () -> Unit) {
    CardStorageAppBar(vertical = true, onClick = toHorizental)
}