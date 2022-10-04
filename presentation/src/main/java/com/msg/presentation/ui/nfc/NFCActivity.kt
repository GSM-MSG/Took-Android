package com.msg.presentation.ui.nfc

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.nfc.*
import android.nfc.tech.Ndef
import android.nfc.tech.NfcF
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.msg.presentation.R
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException

@AndroidEntryPoint
class NFCActivity : ComponentActivity() {

    private var intentFiltersArray: Array<IntentFilter>? = null
    private val techListsArray = arrayOf(arrayOf(NfcF::class.java.name))
    private val nfcAdapter: NfcAdapter? by lazy {
        NfcAdapter.getDefaultAdapter(this)
    }
    private var pendingIntent: PendingIntent? = null
    private val TAG = "NFCActivity_TAG"
    private var isRunNFC = false
    private var cardId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFCScreen(onClick = { checkNFC(this) }, nfcAdapter = nfcAdapter)
        }
        pendingIntent = PendingIntent.getActivity(
            this, 0, Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0
        )
        val ndef = IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED)
        try {
            ndef.addDataType("text/plain")
        } catch (e: IntentFilter.MalformedMimeTypeException) {
            throw RuntimeException("fail", e)
        }
        intentFiltersArray = arrayOf(ndef)
        Log.d(TAG, "onCreate")
        if (nfcAdapter == null) {
            Toast.makeText(this, R.string.not_support_NFC, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        nfcAdapter?.enableForegroundDispatch(this, pendingIntent, intentFiltersArray, techListsArray)
    }

    override fun onPause() {
        if (this.isFinishing) nfcAdapter?.disableForegroundDispatch(this@NFCActivity)
        super.onPause()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        Log.d(TAG, "onNewIntent")
        val action = intent.action
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == action && isRunNFC) {
            val parcelables = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
            val id = "goose"
            try {
                val inNdefMessage = parcelables!![0] as NdefMessage
                val inNdefRecords = inNdefMessage.records
                var ndefRecord0 = inNdefRecords[0]
                var inMessage = String(ndefRecord0.payload)
                cardId = inMessage.drop(3)
                Log.d(TAG, cardId)

                if (id != "") {
                    if (NfcAdapter.ACTION_TECH_DISCOVERED == action || NfcAdapter.ACTION_NDEF_DISCOVERED == action) {
                        val tag = intent.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG) ?: return
                        val ndef = Ndef.get(tag) ?: return

                        if (ndef.isWritable) {
                            var message = createTagMessage(id)

                            ndef.connect()
                            ndef.writeNdefMessage(message)
                            ndef.close()

                            Log.d(TAG, "write success")
                        }
                    }
                } else {
                    try {
                        ndefRecord0 = inNdefRecords[0]
                        inMessage = String(ndefRecord0.payload)

                        Log.d(TAG, "USER ID: " + inMessage.drop(3))
                    } catch (ex: java.lang.Exception) {
                        Toast.makeText(
                            applicationContext,
                            "User ID not writted!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (e: Exception) {
                e.message
            }
        }
    }

    private fun createTagMessage(msg: String): NdefMessage {
        return NdefMessage(NdefRecord.createTextRecord("en", msg))
    }

    //    버튼을 클릭하였을 때 쓰기 모드로 변환하기
    private fun checkNFC(context: Context) {
        isRunNFC = !isRunNFC
        try {
            if (nfcAdapter == null) {
                Toast.makeText(context, "nfcTagAvailable", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, R.string.write_success, Toast.LENGTH_SHORT).show()
            }
        } catch (e: IOException) {
            Toast.makeText(context, "writeError", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        } catch (e: FormatException) {
            Toast.makeText(context, "writeError", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}

