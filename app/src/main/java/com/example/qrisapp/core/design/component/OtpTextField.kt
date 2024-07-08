package com.example.qrisapp.core.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrisapp.core.design.theme.Color_9CA9B9
import com.example.qrisapp.core.design.theme.Color_ED0226
import com.example.qrisapp.core.design.theme.Color_FFFFFF
import com.example.qrisapp.core.design.theme.QRISTheme


/*
* https://github.com/banmarkovic/OtpTextField/blob/master/app/src/main/java/com/ban/otptextfield/OtpTextField.kt
*/
@Composable
fun OtpTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 6,
    isError: Boolean = false,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    BasicTextField(
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpCount) {
                onOtpTextChange(it.text, it.text.length == otpCount)
            }
        },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(otpCount) { index ->
                    CharView(
                        index = index,
                        text = otpText,
                        isError = isError
                    )
                    if (index < otpCount - 1) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String,
    isError: Boolean = false
) {
    val char = when {
        index >= text.length -> ""
        else -> text[index].toString()
    }
    val borderColor = if (isError) {
        Color_ED0226
    } else {
        Color_9CA9B9
    }

    Text(
        text = char,
        modifier = Modifier
            .size(44.dp)
            .background(Color_FFFFFF.copy(alpha = 0.5f))
            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
            .padding(10.dp),
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleSmall
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewOtpTextField() {
    QRISTheme {
        var otpValue by rememberSaveable { mutableStateOf("") }

        OtpTextField(otpText = otpValue) { value, _ ->
            otpValue = value
        }
    }
}