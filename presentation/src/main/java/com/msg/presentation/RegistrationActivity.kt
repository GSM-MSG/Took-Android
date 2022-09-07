package com.msg.presentation

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.*

class RegistrationActivity : ComponentActivity() {

    private var frontImageUriState = mutableStateOf<Uri?>(null)
    private var backImageUriState = mutableStateOf<Uri?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Background()
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                TopBar()
                Spacer(modifier = Modifier.height(32.dp))
                AddCard()
                Spacer(modifier = Modifier.height(140.dp))
                RegisterBtn()
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }

    @Composable
    fun RegisterBtn() {
        if (frontImageUriState.value != null && backImageUriState.value != null) {
            ButtonGradient(
                onClick = { },
                text = stringResource(id = R.string.finish_set_card),
                Brush.linearGradient(
                    colors = BtnGradientPurple,
                )
            )
        } else {
            Spacer(modifier = Modifier.height(56.dp))
        }
    }

    @Composable
    fun AddCard() {
        Column() {
            ButtonAddCard(
                onClick = { addCardFront() },
                text = stringResource(id = R.string.set_card_front),
                uri = if (frontImageUriState.value != null) frontImageUriState.value!! else null
            )
            Spacer(modifier = Modifier.height(20.dp))
            ButtonAddCard(
                onClick = { addCardBack() },
                text = stringResource(id = R.string.set_card_back),
                uri = null
            )
        }
    }

    @Preview
    @Composable
    fun TopBar() {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { backBtn() }) {
                Icon(
                    Icons.Default.ArrowBackIos,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                DefalutText(text = stringResource(id = R.string.card), 17)
            }
        }
    }

    private fun backBtn() {

    }

    private fun addCardFront() {

    }

    private fun addCardBack() {

    }
}



