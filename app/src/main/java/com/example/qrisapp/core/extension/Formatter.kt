package com.example.qrisapp.core.extension

import androidx.compose.ui.graphics.Color
import com.example.qrisapp.core.design.theme.Color_008E53
import com.example.qrisapp.core.design.theme.Color_CCCFD3
import com.example.qrisapp.core.design.theme.Color_ED0226
import com.example.qrisapp.core.design.theme.Color_FDA22B
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatColor(): Color {
    return when {
        this.equals("Tarik Tunai", true) -> {
            Color_FDA22B
        }

        this.equals("QRIS Payment", true) -> {
            Color_ED0226
        }

        this.equals("Topup Gopay", true) -> {
            Color_008E53
        }

        this.equals("Lainnya", true) -> {
            Color_CCCFD3
        }

        else -> {
            Color_FDA22B
        }
    }
}

fun String.formatDate(): String {
    return try {
        val inputFormat = SimpleDateFormat("dd/MM/yyyy", Locale("id", "ID"))
        val date = inputFormat.parse(this) ?: return ""
        val outputFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
        return outputFormat.format(date)
    } catch (e: Exception) {
        ""
    }
}

fun Int.formatRupiah(): String {
    return try {
        val locale = Locale.getDefault()
        val formatter = NumberFormat.getCurrencyInstance(locale)
        formatter.format(this)
    } catch (e: Exception) {
        ""
    }
}

fun Float.formatPercentage(): String {
    return String.format("%.2f%%", this / 10)
        .replace(",00%", "%")
        .replace("0%", "%")
}