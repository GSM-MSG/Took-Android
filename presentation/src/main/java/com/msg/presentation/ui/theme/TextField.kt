package com.msg.presentation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.msg.presentation.R

@Composable
fun TextFieldNormal(
    label: Int?,
    labelTopMargin: Int = 32,
    topMargin: Int = 4,
    text: String?,
    textChange: (String) -> Unit,
    placeholder: Int,
    isError: Boolean,
    onDone: () -> Unit,
    imeAction: ImeAction = ImeAction.Done,
    modifier: Modifier = Modifier
) {
    Column {
        if (label != null) {
            DefaultText(
                text = stringResource(id = label),
                fontSize = 14,
                modifier = Modifier.padding(start = 16.dp, top = labelTopMargin.dp)
            )
        }
        Spacer(modifier = Modifier.height(topMargin.dp))
        OutlinedTextField(
            value = text ?: "",
            onValueChange = textChange,
            textStyle = TextStyle(color = Color.White),
            placeholder = { DefaultText(text = stringResource(id = placeholder), fontSize = 16, textColor = Color.Gray) },
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
}

@Composable
fun TextFieldVisible() {

}