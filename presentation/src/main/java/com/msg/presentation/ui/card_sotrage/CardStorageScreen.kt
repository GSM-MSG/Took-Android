package com.msg.presentation.ui.card_sotrage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.msg.presentation.ui.theme.Background
import com.msg.presentation.ui.theme.Black3
import com.msg.presentation.ui.theme.CardStorageAppBar

@Composable
@ExperimentalFoundationApi
fun CardStorageScreen(isVertical: Boolean, itemList: ArrayList<String>, onClick: () -> Unit) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "cardList") {
        composable("cardList") {
            Background()
            if (isVertical) CardStorageVerticalScreen(itemList, navController)
            else CardStorageHorizentalScreen(itemList, navController)
            Box(
                modifier = Modifier
                    .background(Black3)
                    .fillMaxWidth()
                    .height(30.dp)
                    .clickable(enabled = false, onClickLabel = null, onClick = {})
            )
            CardStorageAppBar(vertical = isVertical, onClick = onClick)
        }
        composable(
            "detail/{url}", arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) {
            val url = it.arguments?.getString("url")
            Background()
            CardDetailPage(url = url!!) {
                navController.navigate("cardList") {
                    popUpTo("cardList") {
                        inclusive = true
                    }
                }
            }
        }
    }
}