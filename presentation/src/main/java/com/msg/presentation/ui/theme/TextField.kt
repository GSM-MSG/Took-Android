package com.msg.presentation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
    onDone: () -> Unit = {},
    modifier: Modifier = Modifier,
    iconClick: () -> Unit,
    visible: Boolean = true,
    visibleIcon: Int = R.drawable.ic_cancel,
    unVisibleIcon: Int = R.drawable.ic_cancel,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column {
        if (label != null) {
            DefaultText(
                text = label,
                fontSize = 14,
                modifier = Modifier.padding(start = 16.dp, top = labelTopMargin.dp),
                textColor = White3
            )
        }
        Spacer(modifier = Modifier.height(topMargin.dp))
        OutlinedTextField(
            value = text ?: "",
            visualTransformation = if(visible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            onValueChange = textChange,
            textStyle = TextStyle(color = White2),
            placeholder = {
                DefaultText(
                    text = placeholder,
                    fontSize = 16,
                    textColor = Gray3
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 16.dp)
                .background(Black3, RoundedCornerShape(16.dp)),
            singleLine = true,
            isError = isError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Purple2,
                errorBorderColor = Red,
                unfocusedBorderColor = Black1
            ),
            shape = RoundedCornerShape(16.dp),
            keyboardActions = KeyboardActions(
                onDone = { onDone() }
            ),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = if(visible) unVisibleIcon else visibleIcon),
                    contentDescription = null,
                    tint = if(text.isNullOrEmpty()) Transparent else Unspecified,
                    modifier = Modifier.clickable {
                        iconClick()
                    }
                )
            }
        )
    }
}