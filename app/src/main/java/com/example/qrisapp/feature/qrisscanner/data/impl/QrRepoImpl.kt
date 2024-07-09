package com.example.qrisapp.feature.qrisscanner.data.impl

import com.example.qrisapp.feature.qrisscanner.data.model.ScannerModel
import com.example.qrisapp.feature.qrisscanner.data.repo.QrRepo
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

class QrRepoImpl(private val scanner: GmsBarcodeScanner) : QrRepo {
    override fun startScanning(): Flow<ScannerModel> {
        return callbackFlow {
            scanner.startScan()
                .addOnSuccessListener {
                    launch {
                        send(getDetails(it))
                    }
                }.addOnFailureListener {
                    it.printStackTrace()
                }
            awaitClose { }
        }
    }

    private fun getDetails(barcode: Barcode): ScannerModel {
        return when (barcode.valueType) {
            Barcode.TYPE_TEXT -> {
                val result = "${barcode.rawValue}"
                val model = ScannerModel()
                result.split(".").forEachIndexed { index, item ->
                    when (index) {
                        0 -> {
                            model.bankSender = item
                        }

                        1 -> {
                            model.transactionId = item
                        }

                        2 -> {
                            model.merchantName = item
                        }

                        3 -> {
                            model.transactionAmount = item
                        }
                    }
                }
                return model
            }


            else -> {
                ScannerModel()
            }
        }
    }
}