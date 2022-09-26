package com.msg.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.msg.presentation.R
import com.msg.presentation.ui.nfc.NFCActivity
import com.msg.presentation.ui.theme.Background
import com.msg.presentation.ui.theme.TookAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Background()
            Button(onClick = { buttonClick() }) {
                Text(text = "Button")
            }
        }
    }

    private fun buttonClick() {
        val intent = Intent(this, NFCActivity::class.java)
        startActivity(intent)
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    TookAndroidTheme {
        Background()
    }
}

