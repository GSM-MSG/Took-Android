package com.msg.presentation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldNormal(
    text: String?,
    textChange: (String) -> Unit,
    placeholder: String,
    isError: Boolean,
    onDone: () -> Unit,
    imeAction: ImeAction = ImeAction.Done,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = text ?: "",
        onValueChange = textChange,
        textStyle = TextStyle(color = Color.White),
        placeholder = { DefaultText(text = placeholder, fontSize = 16, textColor = Color.Gray) },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
            .background(Color(0x661A1A20)),
        singleLine = true,
        isError = isError,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            errorBorderColor = Color.Red,
            unfocusedBorderColor = Color(0xFF1D191E)
        ),
        shape = RoundedCornerShape(16.dp),
        keyboardActions = KeyboardActions(
            onDone = { onDone() }
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = imeAction)
    )
}

@Composable
fun TextFieldVisible() {

}