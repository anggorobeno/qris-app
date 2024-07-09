package com.example.qrisapp.feature.qrisscanner.data.repo

import com.example.qrisapp.feature.qrisscanner.data.model.ScannerModel
import kotlinx.coroutines.flow.Flow

interface QrRepo {
    fun startScanning(): Flow<ScannerModel>
}