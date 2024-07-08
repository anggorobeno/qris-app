package com.example.qrisapp.core.network.util

import com.example.qrisapp.feature.qrisscanner.data.model.ScannerModel

sealed interface SideEffect {
    data class ShowBottomSheetConfirmation(val data: ScannerModel) : SideEffect
}