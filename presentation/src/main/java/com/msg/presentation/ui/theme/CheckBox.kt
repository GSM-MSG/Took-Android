package com.msg.presentation.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.msg.presentation.R

@Composable
fun agreedCheckBox(
    enabled: Boolean,
    checkChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier.padding(top = 32.dp, start = 32.dp)
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = if (enabled) R.drawable.ic_checkbox_checkd else R.drawable.ic_checkbox_unchecked),
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    checkChange(!enabled)
                },
            tint = Unspecified
        )
        DefaultText(
            text = R.string.all_agreed,
            fontSize = 16,
            textColor = Black2,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun agreed(
    enabled: Boolean,
    checkChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
        .padding(top = 16.dp, start = 32.dp, end = 32.dp)
        .fillMaxWidth(),
    detailAgreed: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = if (enabled) R.drawable.ic_checked else R.drawable.ic_unchecked),
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    checkChange(!enabled)
                },
            tint = Unspecified
        )
        DefaultText(
            text = R.string.agreed,
            fontSize = 14,
            textColor = Gray1,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Rounded.KeyboardArrowRight,
            contentDescription = null,
            tint = White2,
            modifier = Modifier.clickable {
                detailAgreed()
            })
    }
}