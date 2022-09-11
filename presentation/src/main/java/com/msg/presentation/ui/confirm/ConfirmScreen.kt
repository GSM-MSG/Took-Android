package com.msg.presentation.ui.confirm

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.msg.presentation.R
import com.msg.presentation.ui.theme.*

@Composable
fun ConfirmScreen(back: () -> Unit, toNext: () -> Unit) {
    var confirmArray by remember { mutableStateOf<Array<Int?>>(arrayOf(null, null, null, null)) }
    var currentConfirm by remember { mutableStateOf(0) }
    var isError by remember { mutableStateOf(false) }
    fun isNumber() {
        var password = ""
        confirmArray.forEachIndexed { index, it ->
            when (it) {
                R.string.one -> password += "1"
                R.string.two -> password += "2"
                R.string.three -> password += "3"
                R.string.four -> password += "4"
                R.string.five -> password += "5"
                R.string.six -> password += "6"
                R.string.seven -> password += "7"
                R.string.eight -> password += "8"
                R.string.nine -> password += "9"
                R.string.zero -> password += "0"
            }
        }
        confirmArray = arrayOf(null, null, null, null)
        currentConfirm = 0
        if (password.equals("1234")) {
            toNext()
        } else {
            isError = true
        }
    }

    fun writeText(number: Int) {
        isError = false
        if (number != 10 && currentConfirm <= 2) {
            confirmArray[currentConfirm++] = number
        } else if (number == 10 && currentConfirm > 0) {
            confirmArray[--currentConfirm] = null
        } else if (currentConfirm == 3) {
            confirmArray[currentConfirm++] = number
            isNumber()
        }
    }
    Background()
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TookAppBar(back = { back() }, title = R.string.confirm)
        DefaultText(
            text = R.string.send_confirm,
            fontSize = 16,
            textColor = White2,
            modifier = Modifier
                .padding(top = 96.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        ConfirmNumber(confirmArray = confirmArray, current = currentConfirm)
        Spacer(modifier = Modifier.weight(1f))
        ErrorText(
            isError = isError,
            errorMsg = R.string.wrong_confirm,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .height(50.dp)
                .background(White1, RoundedCornerShape(8.dp))
        )
        CustomKeyboard(writeText = { writeText(it) })
    }
}

@Composable
fun ConfirmNumber(confirmArray: Array<Int?>, current: Int) {
    Row(
        modifier = Modifier
            .width(240.dp)
            .height(60.dp)
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BoxNumerText(
            text = confirmArray[0],
            modifier = Modifier.width(48.dp),
            fontSize = 18,
            position = 0,
            current = current
        )
        BoxNumerText(
            text = confirmArray[1],
            modifier = Modifier.width(48.dp),
            fontSize = 18,
            position = 1,
            current = current
        )
        BoxNumerText(
            text = confirmArray[2],
            modifier = Modifier.width(48.dp),
            fontSize = 18,
            position = 2,
            current = current
        )
        BoxNumerText(
            text = confirmArray[3],
            modifier = Modifier.width(48.dp),
            fontSize = 18,
            position = 3,
            current = current
        )
    }
}

@Composable
fun CustomKeyboard(
    writeText: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .height(380.dp)
            .background(Black3)
    ) {
        KeyboardRow(
            leftString = R.string.one,
            centerString = R.string.two,
            rightString = R.string.three,
            modifier = Modifier.weight(0.25f),
            onClick = { writeText(it) }
        )
        KeyboardRow(
            leftString = R.string.four,
            centerString = R.string.five,
            rightString = R.string.six,
            modifier = Modifier.weight(0.25f),
            onClick = { writeText(it) }
        )
        KeyboardRow(
            leftString = R.string.seven,
            centerString = R.string.eight,
            rightString = R.string.nine,
            modifier = Modifier.weight(0.25f),
            onClick = { writeText(it) }
        )
        KeyboardRow(
            leftString = null,
            centerString = R.string.zero,
            rightImg = R.drawable.ic_delete,
            modifier = Modifier.weight(0.25f),
            onClick = { writeText(it) }
        )
    }
}

@Composable
fun KeyboardRow(
    leftString: Int?,
    centerString: Int,
    rightString: Int = 0,
    modifier: Modifier,
    rightImg: Int? = null,
    onClick: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        if (leftString != null)
            BoxText(
                text = leftString,
                modifier = Modifier.weight(0.3f),
                fontSize = 16,
                onClick = { onClick(it) })
        else
            Box(modifier = Modifier.weight(0.3f))
        BoxText(
            text = centerString,
            modifier = Modifier.weight(0.3f),
            fontSize = 16,
            onClick = { onClick(it) })
        if (rightImg == null)
            BoxText(
                text = rightString,
                modifier = Modifier.weight(0.3f),
                fontSize = 16,
                onClick = { onClick(it) })
        else
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.3f)
                    .clickable { onClick(10) },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = rightImg),
                    contentDescription = null,
                    tint = Unspecified
                )
            }
    }
}