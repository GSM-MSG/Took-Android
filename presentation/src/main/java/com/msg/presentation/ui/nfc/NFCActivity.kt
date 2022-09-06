package com.msg.presentation.ui.nfc

import android.app.PendingIntent
import android.content.Intent
import android.nfc.NfcAdapter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.Background

class NFCActivity : ComponentActivity() {

    private val TAG = "NFCActivity:TAG"
    private lateinit var nfcPendingIntent: PendingIntent
    private var nfcAdapter: NfcAdapter? = null
    private val NFCTagAvailable = "NFC is not available"
    private val WriteSuccess = "Text Write Successfully"
    private val WriteError = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        if(nfcAdapter == null) {
            Log.d(TAG, NFCTagAvailable)
        } else {
            Log.d(TAG, "$nfcAdapter")
        }
        nfcPendingIntent = PendingIntent.getActivity(
            this, 0,
            Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0)
        setContent {
            Background()
            Column(modifier = Modifier) {
                Button(
                    onClick = { }, modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "NFC")
                }
            }
        }
    }
}

