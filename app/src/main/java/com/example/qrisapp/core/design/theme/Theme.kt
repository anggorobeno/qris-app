package com.example.qrisapp.core.design.theme

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


val lightScheme = lightColorScheme(
    primary = Color_ED0226,
    surface = Color_FFFFFF,
    background = Color_FFFFFF
)

@Composable
fun QRISTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightScheme,
        typography = typography,
        content = {
            Surface(
                modifier = Modifier.navigationBarsPadding(),
                color = Color.Transparent
            ) {
                content()
            }
        }
    )
}