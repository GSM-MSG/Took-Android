package com.msg.presentation.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.msg.presentation.ui.theme.Background
import com.msg.presentation.ui.theme.TookAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Background()
        }
    }


}


@Preview(showBackground = true)
@Composable
fun Preview() {
    TookAndroidTheme {
        Background()
    }
}

