package com.msg.presentation.ui.registration

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msg.presentation.MainActivity
import com.msg.presentation.ui.theme.*

class RegistrationActivity : ComponentActivity() {

    private var frontImageUriState = mutableStateOf<Uri?>(null)
    private var backImageUriState = mutableStateOf<Uri?>(null)

    private val selectFrontImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        frontImageUriState.value = uri
    }

    private val selectBackImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        backImageUriState.value = uri
    }

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
                onClick = { cardRegistraion() },
                text = "등록완료!",
                Brush.linearGradient(
                    colors = BtnGradient,
                )
            )
        } else {
            Spacer(modifier = Modifier.height(56.dp))
        }
    }

    @Composable
    fun AddCard() {
        Column {
            ButtonAddCard(
                onClick = { addCardFront() },
                text = "앞면 등록하기",
                uri = if (frontImageUriState.value != null) frontImageUriState.value!! else null
            )
            Spacer(modifier = Modifier.height(20.dp))
            ButtonAddCard(
                onClick = { addCardBack() },
                text = "뒷면 등록하기",
                uri = if (backImageUriState.value != null) backImageUriState.value!! else null
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
                DefalutText(text = "명함 등록", 17)
            }
        }
    }

    private fun backBtn() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun addCardFront() {
        selectFrontImageLauncher.launch("image/*")
    }

    private fun addCardBack() {
        selectBackImageLauncher.launch("image/*")
    }

    private fun cardRegistraion() {

    }
}



