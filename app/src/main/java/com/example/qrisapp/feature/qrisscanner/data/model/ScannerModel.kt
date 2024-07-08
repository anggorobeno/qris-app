package com.example.qrisapp.feature.qrisscanner.data.model

data class ScannerModel(
    var bankSender: String = "",
    var transactionId: String = "",
    var merchantName: String = "",
    var transactionAmount: String = "",
)
