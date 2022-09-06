package com.msg.presentation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldNormal(
    text: String,
    textChange: (String) -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        value = text ?: "",
        onValueChange = textChange,
        textStyle = TextStyle(color = Color.White),
        placeholder = { Text(text = placeholder, color = Color(0xFF7E7E87))},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
            .background(Color(0x661A1A20))
            .border(color = Color(0xFF1D191E), width = 1.dp, shape = RoundedCornerShape(16.dp)),
    )
}