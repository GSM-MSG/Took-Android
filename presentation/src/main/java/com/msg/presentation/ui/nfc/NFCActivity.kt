package com.msg.presentation.ui.nfc

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.nfc.*
import android.nfc.tech.Ndef
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.msg.presentation.R
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset

@AndroidEntryPoint
class NFCActivity : ComponentActivity() {

    private lateinit var nfcPendingIntent: PendingIntent
    private var nfcAdapter: NfcAdapter? = null
    private lateinit var tag: Tag
    private val TAG: String = "NFCActivity_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        nfcPendingIntent = PendingIntent.getActivity(
            this, 0,
            Intent(this, javaClass), PendingIntent.FLAG_IMMUTABLE
        )
        if (nfcAdapter == null) {
            Toast.makeText(this, R.string.not_support_NFC, Toast.LENGTH_SHORT).show()
        }

//        readFromIntent(intent)
//        val intent = Intent(this, this::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//        nfcPendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
//        val tagDetected = IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED)
//        tagDetected.addCategory(Intent.CATEGORY_DEFAULT)
//        val writeTagFilter = IntentFilter()
//        tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)!!


        setContent {
            NFCScreen(onClick = { checkNFC(this) }, nfcAdapter = nfcAdapter)
        }
    }

    override fun onResume() {
        super.onResume()
        nfcAdapter?.enableForegroundDispatch(this, nfcPendingIntent, null, null)
    }

    override fun onPause() {
        super.onPause()
        nfcAdapter?.disableForegroundDispatch(this)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        val detectedTag: Tag? = intent?.getParcelableExtra(NfcAdapter.EXTRA_TAG)
        val writeValue: String = "test"
        val message: NdefMessage = createTagMessage(writeValue);

        if(detectedTag != null) writeTag(message, detectedTag)

//        setIntent(intent)
//        readFromIntent(intent!!)
//        if(NfcAdapter.ACTION_TAG_DISCOVERED == intent.action) {
//            tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)!!
//        }
    }

    private fun createTagMessage(msg: String): NdefMessage {
        return NdefMessage(NdefRecord.createUri(msg))
    }

    private fun writeTag(message: NdefMessage, tag: Tag) {
        val size = message.toByteArray().size
        try {
            val ndef = Ndef.get(tag)
            if (ndef != null) {
                ndef.connect()
                if (!ndef.isWritable) {
                    Toast.makeText(applicationContext, "can not write NFC tag", Toast.LENGTH_SHORT).show()
                }
                if (ndef.maxSize < size) {
                    Toast.makeText(applicationContext, "NFC tag size too large", Toast.LENGTH_SHORT).show()
                }
                ndef.writeNdefMessage(message)
                Toast.makeText(applicationContext, "NFC tag is writted", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Log.i(TAG,e.message!!)
            e.printStackTrace()
        }
    }


    //    버튼을 클릭하였을 때 쓰기 모드로 변환하기
    private fun checkNFC(context: Context) {
        try {
            if (nfcAdapter == null) {
                Toast.makeText(context, "nfcTagAvailable", Toast.LENGTH_SHORT).show()
            } else {
                write("test", tag)
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

    private fun readFromIntent(intent: Intent) {
        val action = intent.action
        if (
            NfcAdapter.ACTION_NDEF_DISCOVERED == action ||
            NfcAdapter.ACTION_TECH_DISCOVERED == action ||
            NfcAdapter.ACTION_TAG_DISCOVERED == action
        ) {
            val rawMsgs: Array<Parcelable> =
                intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES) as Array<Parcelable>
            val msgs = mutableListOf<NdefMessage>()

            for (i in 0..rawMsgs.size) {
                msgs.add(i, rawMsgs[i] as NdefMessage)
            }
            buildTagViews(msgs)
        }
    }

    private fun buildTagViews(msgs: MutableList<NdefMessage>) {
        if (msgs.isNullOrEmpty()) {
            var text = ""
            val payload: ByteArray = msgs[0].records[0].payload
            val textEncoding = if ((payload[0].toInt() and 128) == 0) "UTF-8" else "UTF-16"
            val languageCodeLength = payload[0].toInt() and 63

            try {
                text = String(
                    payload,
                    languageCodeLength + 1,
                    payload.size - languageCodeLength - 1,
                    textEncoding as Charset
                )
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            }
        } else return
    }

    @Throws(UnsupportedEncodingException::class, FormatException::class)
    private fun write(msg: String, tag: Tag) {
        val records: NdefRecord = createRecord(msg)
        val message = NdefMessage(records)

        val ndef: Ndef = Ndef.get(tag)
        ndef.connect()
        ndef.writeNdefMessage(message)
        ndef.close()
    }

    @Throws(UnsupportedEncodingException::class)
    private fun createRecord(text: String): NdefRecord {
        val lang = "en"
        val textBytes = text.toByteArray()
        val langBytes = lang.toByteArray("US-ASCII" as Charset)
        val langLength = langBytes.size
        val textLength = textBytes.size
        val payload = ByteArray(1 + langLength + textLength)

        payload[0] = langLength.toByte()

        System.arraycopy(langBytes, 0, payload, 1, langLength)
        System.arraycopy(textBytes, 0, payload, 1 + textLength, textLength)

        return NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, ByteArray(0), payload)
    }
}

