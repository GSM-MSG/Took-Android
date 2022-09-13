package com.msg.presentation.ui.card_sotrage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.Background
import com.msg.presentation.ui.theme.Black3
import com.msg.presentation.ui.theme.CardStorageAppBar

@Composable
@ExperimentalFoundationApi
fun CardStorageScreen(isVertical: Boolean, itemList: ArrayList<String>, onClick: () -> Unit) {
    Background()
    if (isVertical) CardStorageVerticalScreen(itemList) else CardStorageHorizentalScreen(itemList)
    Box(
        modifier = Modifier
            .background(Black3)
            .fillMaxWidth()
            .height(30.dp)
    )
    CardStorageAppBar(vertical = isVertical, onClick = onClick)
}