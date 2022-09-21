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
        } catch (e: Exception) {
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
        super.onPause()
        if(this.isFinishing) nfcAdapter?.disableForegroundDispatch(this@NFCActivity)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        try {
            val id = "good"

            if (NfcAdapter.ACTION_TECH_DISCOVERED == intent.action
                || NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action
            ) {
                val tag = intent.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG) ?: return
                val ndef = Ndef.get(tag) ?: return

                if (ndef.isWritable) {
                    var message = NdefMessage(arrayOf(NdefRecord.createTextRecord("en", id)))

                    ndef.connect()
                    ndef.writeNdefMessage(message)
                    ndef.close()

                    Toast.makeText(applicationContext, "Successfully Wroted!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext, "Write on text box!", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.message
        }
        Log.d(TAG, "onNewIntent")
    }

//    private fun createTagMessage(msg: String): NdefMessage {
//        return NdefMessage(NdefRecord.createTextRecord("en", msg))
//    }
//
//    private fun writeTag(message: NdefMessage, tag: Tag) {
//        val size = message.toByteArray().size
//        try {
//            val ndef = Ndef.get(tag)
//            if (ndef != null) {
//                ndef.connect()
//                Toast.makeText(applicationContext, "NFC connect", Toast.LENGTH_SHORT).show()
//                if (!ndef.isWritable) {
//                    Toast.makeText(applicationContext, "can not write NFC tag", Toast.LENGTH_SHORT)
//                        .show()
//                }
//                if (ndef.maxSize < size) {
//                    Toast.makeText(applicationContext, "NFC tag size too large", Toast.LENGTH_SHORT)
//                        .show()
//                }
//                ndef.writeNdefMessage(message)
//                Toast.makeText(applicationContext, "NFC tag is writted", Toast.LENGTH_SHORT).show()
//            } else Toast.makeText(applicationContext, "NFC connect failed", Toast.LENGTH_SHORT)
//                .show()
//        } catch (e: Exception) {
//            Log.i(TAG, e.message!!)
//            Toast.makeText(applicationContext, "Exception", Toast.LENGTH_SHORT).show()
//            e.printStackTrace()
//        }
//    }


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

