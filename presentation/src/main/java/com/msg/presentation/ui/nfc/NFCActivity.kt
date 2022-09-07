package com.msg.presentation.ui.nfc

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.nfc.FormatException
import android.nfc.NfcAdapter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.msg.presentation.ui.theme.Background
import java.io.IOException

class NFCActivity : ComponentActivity() {

    private val TAG = "NFCActivity:TAG"
    private lateinit var nfcPendingIntent: PendingIntent
    private var nfcAdapter: NfcAdapter? = null
    private val NFCTagAvailable = "NFC is not available"
    private val WriteSuccess = "Text Write Successfully"
    private val WriteError = "Failed to write text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        if (nfcAdapter == null) {
            Log.d(TAG, NFCTagAvailable)
        } else {
            Log.d(TAG, "$nfcAdapter")
        }
        nfcPendingIntent = PendingIntent.getActivity(
            this, 0,
            Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0
        )
        setContent {
            Background()
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

    private fun writeNFC(context: Context) {
        try {
            if(nfcAdapter == null) {
                Toast.makeText(context, NFCTagAvailable, Toast.LENGTH_SHORT).show()
            } else {

            }
        } catch (e: IOException) {
            Toast.makeText(context, WriteError, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        } catch (e: FormatException) {
            Toast.makeText(context, WriteError, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}

