package com.msg.presentation.ui.nfc

import android.nfc.NfcAdapter
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.internal.isLiveLiteralsEnabled
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.msg.presentation.R
import com.msg.presentation.ui.theme.Background

@Composable
fun NFCScreen(onClick: () -> Unit, nfcAdapter: NfcAdapter? = null) {

    var isLottieAnimationPlaying by remember { mutableStateOf(false) }

    val compositionResult: LottieCompositionResult =
        rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.nfc_effect))
    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = isLottieAnimationPlaying,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    Surface(modifier = Modifier.fillMaxSize()) {
        Background()
        LottieAnimation(
            composition = compositionResult.value,
            progress = progress,
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    if(nfcAdapter != null) {
                        onClick()
                        isLottieAnimationPlaying = !isLottieAnimationPlaying
                    }
                },
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
            ) {
                Text(text = "NFC")
            }
        }
    }
}