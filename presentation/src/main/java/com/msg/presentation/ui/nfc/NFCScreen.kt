package com.msg.presentation.ui.nfc

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.msg.presentation.R
import com.msg.presentation.ui.theme.Background

@Composable
fun NFCScreen(onClick: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Background()
        NfcLottie()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { onClick() }, modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
            ) {
                Text(text = "NFC")
            }
        }
    }
}

@Composable
fun NfcLottie() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.nfc_effect))
    LottieAnimation(
        composition = composition,
        iterations = Int.MAX_VALUE
    )
}