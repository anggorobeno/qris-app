package com.example.qrisapp.core.design.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.qrisapp.R

val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)


private val defaultTypography = Typography()

val typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(
        fontSize = 52.sp,
        fontFamily = poppinsFamily
    ),
    displayMedium = defaultTypography.displayMedium.copy(
        fontSize = 44.sp,
        fontFamily = poppinsFamily
    ),
    displaySmall = defaultTypography.displaySmall.copy(
        fontSize = 36.sp,
        fontFamily = poppinsFamily
    ),
    headlineLarge = defaultTypography.headlineLarge.copy(
        fontSize = 32.sp,
        fontFamily = poppinsFamily
    ),
    headlineMedium = defaultTypography.headlineMedium.copy(
        fontSize = 28.sp,
        fontFamily = poppinsFamily
    ),
    headlineSmall = defaultTypography.headlineSmall.copy(
        fontSize = 24.sp,
        fontFamily = poppinsFamily
    ),
    titleLarge = defaultTypography.titleLarge.copy(
        fontSize = 22.sp,
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal
    ),
    titleMedium = defaultTypography.titleMedium.copy(
        fontSize = 20.sp,
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal
    ),
    titleSmall = defaultTypography.titleSmall.copy(
        fontSize = 18.sp,
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal
    ),
    bodyLarge = defaultTypography.bodyLarge.copy(
        fontSize = 16.sp,
        fontFamily = poppinsFamily
    ),
    bodyMedium = defaultTypography.bodyMedium.copy(
        fontSize = 14.sp,
        fontFamily = poppinsFamily
    ),
    bodySmall = defaultTypography.bodySmall.copy(
        fontSize = 12.sp,
        fontFamily = poppinsFamily
    ),
    labelLarge = defaultTypography.labelLarge.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily
    ),
    labelMedium = defaultTypography.labelMedium.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily
    ),
    labelSmall = defaultTypography.labelSmall.copy(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily
    )
)