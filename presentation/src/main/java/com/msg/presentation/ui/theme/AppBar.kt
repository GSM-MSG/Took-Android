package com.msg.presentation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.ViewAgenda
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.msg.presentation.R

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
        Box(
            modifier = Modifier.fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBackIos,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clickable {
                        back()
                    },
                tint = White1
            )
        }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultText(
                text = title,
                fontSize = 17
            )
        }
    }
}

@Composable
fun CardStorageAppBar(
    vertical: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Rounded.ViewAgenda,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable {
                        onClick()
                    },
                tint = if (vertical) Gray5 else White1
            )

            Icon(
                imageVector = Icons.Rounded.ViewAgenda,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .rotate(90f)
                    .clickable {
                        onClick()
                    },
                tint = if (!vertical) Gray5 else White1
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultText(
                text = R.string.card_list,
                fontSize = 17
            )
        }
    }
}