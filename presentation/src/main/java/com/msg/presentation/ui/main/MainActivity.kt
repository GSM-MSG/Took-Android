package com.msg.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.msg.presentation.ui.card_sotrage.CardStorageScreen
import com.msg.presentation.ui.theme.Background
import com.msg.presentation.ui.theme.TookAndroidTheme
import com.msg.presentation.viewmodel.card_storage.CardStorageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val cardStorageViewModel by viewModels<CardStorageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Background()
//            Button(onClick = { buttonClick() }) {
//                Text(text = "Button")
//            }
            CardStorage(itemList = arrayListOf("a1", "a2", "a3", "a4", "a5", "a6"))
        }
    }

//    private fun buttonClick() {
//        val intent = Intent(this, NFCActivity::class.java)
//        startActivity(intent)
//    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardStorage(itemList: ArrayList<String>) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "vertical") {
        composable("vertical") {
            CardStorageScreen(isVertical = true, itemList = itemList) {
                navController.navigate("horizental") {
                    popUpTo("vertical") {
                        inclusive = true
                    }
                }
            }
        }
        composable("horizental") {
            CardStorageScreen(isVertical = false, itemList = itemList) {
                navController.navigate("vertical") {
                    popUpTo("horizental") {
                        inclusive = true
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    TookAndroidTheme {
        Background()
    }
}

