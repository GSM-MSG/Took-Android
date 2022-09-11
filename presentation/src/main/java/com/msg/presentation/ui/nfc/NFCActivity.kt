package com.msg.presentation.ui.nfc

import android.app.PendingIntent
import android.content.Context
import android.nfc.FormatException
import android.nfc.NfcAdapter
import android.os.Bundle
import android.util.Log
import android.view.Surface
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException

@AndroidEntryPoint
class NFCActivity : ComponentActivity() {

    private val tag = "NFCActivity:TAG"
    private lateinit var nfcPendingIntent: PendingIntent
    private var nfcAdapter: NfcAdapter? = null
    private val nfcTagAvailable = "NFC is not available"
    private val writeSuccess = "Text Write Successfully"
    private val writeError = "Failed to write text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        if (nfcAdapter == null) {
            Log.d(tag, nfcTagAvailable)
        } else {
            Log.d(tag, "$nfcAdapter")
        }
        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                Background()
                NfcLottie()
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { writeNFC(context = this@NFCActivity) }, modifier = Modifier
                            .width(300.dp)
                            .height(50.dp)
                    ) {
                        Text(text = "NFC")
                    }
                }
            }
        }
    }

//    버튼을 클릭하였을 때 쓰기 모드로 변환하기
    private fun writeNFC(context: Context) {
        try {
            if (nfcAdapter == null) {
                Toast.makeText(context, nfcTagAvailable, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, writeSuccess, Toast.LENGTH_SHORT).show()
            }
        } catch (e: IOException) {
            Toast.makeText(context, writeError, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        } catch (e: FormatException) {
            Toast.makeText(context, writeError, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
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

}

