package com.msg.presentation.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun TookAppBar(
    back: () -> Unit,
    title: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBackIos,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .clickable {
                    back()
                },
            tint = Color.White
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            DefaultText(
                text = stringResource(id = title),
                fontSize = 17
            )
        }
    }
}