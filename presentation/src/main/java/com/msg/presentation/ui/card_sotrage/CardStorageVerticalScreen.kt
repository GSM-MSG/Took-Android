package com.msg.presentation.ui.card_sotrage

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.Black3
import com.msg.presentation.ui.theme.CardStorageAppBar
import com.msg.presentation.ui.theme.TookBackground

@Composable
@ExperimentalFoundationApi
fun CardStorageVerticalScreen(toHorizental: () -> Unit) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
        items(20) {
            Box(
                modifier = Modifier
                    .padding(9.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color.White)
                    .height(280.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "더미")
            }
        }
    })
    Box(
        modifier = Modifier
            .background(Black3)
            .fillMaxWidth()
            .height(30.dp)
    )
    CardStorageAppBar(vertical = true, onClick = toHorizental)
}

@Preview(showBackground = false)
@Composable
@ExperimentalFoundationApi
fun Preview2() {
    TookBackground()
    CardStorageVerticalScreen {
        Log.d("", "")
    }
}