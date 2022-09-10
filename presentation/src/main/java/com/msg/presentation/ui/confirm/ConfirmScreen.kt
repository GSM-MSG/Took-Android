package com.msg.presentation.ui.confirm

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun ConfirmScreen(back: () -> Unit) {
    var confirmArray by remember { mutableStateOf<Array<Int?>>(arrayOf(null, null, null, null)) }
    var currentConfirm by remember { mutableStateOf(0) }
    fun writeText(number: Int) {
        if (number != 10 && currentConfirm <= 2) {
            confirmArray[currentConfirm++] = number
        } else if (number == 10 && currentConfirm > 0) {
            confirmArray[--currentConfirm] = null
        } else if (currentConfirm == 3) {
            confirmArray[currentConfirm++] = number
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