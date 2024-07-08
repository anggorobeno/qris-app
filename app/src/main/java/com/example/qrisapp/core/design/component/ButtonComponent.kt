package com.example.qrisapp.core.design.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrisapp.core.design.theme.Color_9CA9B9
import com.example.qrisapp.core.design.theme.Color_DAE0E9
import com.example.qrisapp.core.design.theme.Color_ED0226
import com.example.qrisapp.core.design.theme.QRISTheme

@Composable
fun LabelButton(
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color_ED0226,
    onClick: () -> Unit
) {
    TextButton(
        onClick = { onClick() },
        modifier = modifier.height(18.dp),
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(contentColor = color),
        contentPadding = PaddingValues(horizontal = 2.dp, vertical = 1.dp)
    ) {
        Text(
            text = label,
            fontWeight = fontWeight,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun PrimaryButton(
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    fontWeight: FontWeight = FontWeight.Normal,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.height(48.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(disabledContainerColor = Color_DAE0E9)
    ) {
        Text(
            text = label,
            fontWeight = fontWeight,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun SecondaryButton(
    label: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = modifier.height(48.dp),
        border = BorderStroke(1.dp, Color_ED0226)
    ) {
        Text(
            text = label,
            fontWeight = fontWeight,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun PrimaryButtonSmall(
    label: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.height(36.dp)
    ) {
        Text(
            text = label,
            fontWeight = fontWeight,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun SecondaryButtonSmall(
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: @Composable RowScope.() -> Unit = {},
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = modifier.height(36.dp),
        enabled = enabled,
        border = BorderStroke(1.dp, if (enabled) Color_ED0226 else Color_9CA9B9)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall
        )

        icon()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLabelButton() {
    QRISTheme {
        LabelButton("Label") {}
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrimaryButton() {
    QRISTheme {
        PrimaryButton("Label") {}
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondaryButton() {
    QRISTheme {
        SecondaryButton("Label") {}
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrimaryButtonSmall() {
    QRISTheme {
        PrimaryButtonSmall("Label") {}
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondaryButtonSmall() {
    QRISTheme {
        SecondaryButtonSmall("Label") {}
    }
}