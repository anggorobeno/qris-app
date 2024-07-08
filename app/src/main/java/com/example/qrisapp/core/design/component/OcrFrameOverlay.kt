package com.example.qrisapp.core.design.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qrisapp.core.design.helper.toPx

@Composable
fun OcrFrameOverlay(modifier: Modifier = Modifier) {
    val padding = 32.dp.toPx()
    val round = 10.dp.toPx()

    val paintBackgroundColor = Color(0x991A1A1A)
    val paintClearColor = Color.Transparent
    val paintRoundedColor = Color.White

    val strokeWidth = 2.dp.toPx()
    val dashWidth = 6.dp.toPx()
    val dashGap = 6.dp.toPx()
    val dashEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth, dashGap), 0F)

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        val rectWidth = width - padding
        val rectHeight = rectWidth / 1.6F //10:16 Ratio
        val left = (width / 2F) - (rectWidth / 2F)
        val top = (height / 2F) - (rectHeight / 2F)
        val right = (rectWidth / 2F) + (width / 2F)

        val idCardPhotoRectWidth = rectWidth * 0.25F
        val idCardPhotoRectHeight = idCardPhotoRectWidth * 1.2F //3:4 Ratio
        val idCardPhotoRectLeft = right - idCardPhotoRectWidth - padding
        val idCardPhotoRectTop = (height / 2F) - (idCardPhotoRectHeight / 2F)

        // Draw the dark background
        drawRect(
            color = paintBackgroundColor,
            size = size
        )

        // Clear the main rectangle
        drawRoundRect(
            color = paintClearColor,
            topLeft = Offset(left, top),
            size = Size(rectWidth, rectHeight),
            cornerRadius = CornerRadius(round, round),
            blendMode = BlendMode.Clear
        )

        // Draw the white rounded border
        drawRoundRect(
            color = paintRoundedColor,
            topLeft = Offset(left, top),
            size = Size(rectWidth, rectHeight),
            cornerRadius = CornerRadius(round, round),
            style = Stroke(
                width = strokeWidth,
                pathEffect = dashEffect
            )
        )

        // Draw the ID card photo rounded border
        drawRoundRect(
            color = paintRoundedColor,
            topLeft = Offset(idCardPhotoRectLeft, idCardPhotoRectTop),
            size = Size(idCardPhotoRectWidth, idCardPhotoRectHeight),
            cornerRadius = CornerRadius(round, round),
            style = Stroke(
                width = strokeWidth,
                pathEffect = dashEffect
            )
        )
    }
}

@Preview
@Composable
fun OcrFrameOverlayPreview() {
    OcrFrameOverlay()
}
