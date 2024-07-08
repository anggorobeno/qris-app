package com.example.qrisapp.core.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrisapp.core.design.theme.Color_001A41
import com.example.qrisapp.core.design.theme.Color_181C21
import com.example.qrisapp.core.design.theme.Color_DAE0E9
import com.example.qrisapp.core.design.theme.Color_FFFFFF
import com.example.qrisapp.core.design.theme.QRISTheme


@Composable
fun Chip(
    modifier: Modifier = Modifier,
    label: String = "",
    enabled: Boolean = false,
    singleLine: Boolean = true
) {
    val textColor = if (enabled) {
        Color_FFFFFF
    } else {
        Color_181C21
    }
    val containerColor = if (enabled) {
        Color_001A41
    } else {
        Color_FFFFFF
    }
    val borderColor = if (enabled) {
        Color.Transparent
    } else {
        Color_DAE0E9
    }
    Text(
        text = label,
        modifier = modifier
            .padding(horizontal = 4.dp, vertical = if (singleLine) 0.dp else 4.dp)
            .background(containerColor, RoundedCornerShape(16.dp))
            .border(1.dp, borderColor, RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp),
        color = textColor,
        style = MaterialTheme.typography.bodySmall
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewChip() {
    QRISTheme {
        Chip(label = "Promo")
    }
}