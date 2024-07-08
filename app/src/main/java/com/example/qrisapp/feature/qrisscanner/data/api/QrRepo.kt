package com.example.qrisapp.feature.qrisscanner.data.api

import kotlinx.coroutines.flow.Flow

interface QrRepo {
    fun startScanning(): Flow<String>
}