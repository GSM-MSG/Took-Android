package com.msg.presentation.ui.registration

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.msg.presentation.MainActivity
import com.msg.presentation.R
import com.msg.presentation.ui.theme.*
import com.msg.presentation.util.UriUtil
import com.msg.presentation.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody

@AndroidEntryPoint
class RegistrationActivity : ComponentActivity() {

    private var frontImageUriState = mutableStateOf<Uri?>(null)
    private var backImageUriState = mutableStateOf<Uri?>(null)
    private var imageList = mutableListOf<MultipartBody.Part>()
    private val imageViewModel by viewModels<ImageViewModel>()

    private val selectFrontImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            frontImageUriState.value = uri
            val fileBody: RequestBody =
                RequestBody.create(MediaType.parse("image/*"), UriUtil.toFile(this, uri!!))
            val fileName = UriUtil.getFileName(this, uri)
            val file: MultipartBody.Part =
                MultipartBody.Part.createFormData("photo", fileName, fileBody)
            imageList.add(file)
        }

    private val selectBackImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            backImageUriState.value = uri
            val fileBody: RequestBody =
                RequestBody.create(MediaType.parse("image/*"), UriUtil.toFile(this, uri!!))
            val fileName = UriUtil.getFileName(this, uri)
            val file: MultipartBody.Part =
                MultipartBody.Part.createFormData("photo", fileName, fileBody)
            imageList.add(file)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Background()
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                TookAppBar(back = { backBtn() }, title = R.string.card)
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
                text = R.string.finish_set_card,
                Brush.linearGradient(
                    colors = GradientPurple,
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
                text = R.string.set_card_front,
                uri = frontImageUriState.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            ButtonAddCard(
                onClick = { addCardBack() },
                text = R.string.set_card_back,
                uri = backImageUriState.value
            )
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



