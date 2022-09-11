package com.msg.presentation.ui.nfc

import android.app.PendingIntent
import android.content.Context
import android.nfc.FormatException
import android.nfc.NfcAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.msg.presentation.R
import java.io.IOException

class NFCActivity : ComponentActivity() {

    private lateinit var nfcPendingIntent: PendingIntent
    private var nfcAdapter: NfcAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        if(nfcAdapter == null) {
            Toast.makeText(this, R.string.not_support_NFC, Toast.LENGTH_SHORT).show()
        }
        setContent {
            NFCScreen(onClick = {checkNFC(this) }, nfcAdapter = nfcAdapter)
        }
    }

//    버튼을 클릭하였을 때 쓰기 모드로 변환하기
    private fun checkNFC(context: Context) {
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

