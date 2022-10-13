package com.msg.presentation.ui.card_sotrage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
@ExperimentalFoundationApi
fun CardStorageVerticalScreen(itemList: ArrayList<String>, navController: NavHostController) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
        items(itemList.size) { index ->
            Box(
                modifier = Modifier
                    .padding(9.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color.White)
                    .width(156.dp)
                    .height(258.dp)
                    .clickable { navController.navigate("detail/${itemList[index]}") },
                contentAlignment = Alignment.Center
            ) {
                Text(text = itemList[index])
            }
        }
    })
}