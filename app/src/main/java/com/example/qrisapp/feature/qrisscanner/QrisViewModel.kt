package com.example.qrisapp.feature.qrisscanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrisapp.core.extension.state
import com.example.qrisapp.di.StorageHelper
import com.example.qrisapp.feature.qrisscanner.data.model.ScannerModel
import com.example.qrisapp.feature.qrisscanner.data.repo.QrRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QrisViewModel @Inject constructor(val repo: QrRepo, val storage: StorageHelper) :
    ViewModel() {
    private val _state = MutableStateFlow(ScannerModel())
    val state = _state.asStateFlow()
    val userBalance = storage.getBalance().state(viewModelScope, 0L)

    fun startScanning() {
        viewModelScope.launch {
            repo.startScanning().collect {
                _state.value = state.value.copy(
                    bankSender = it.bankSender,
                    transactionId = it.transactionId,
                    merchantName = it.merchantName,
                    transactionAmount = it.transactionAmount
                )
            }
        }
    }

    fun setBalance(balance: Long) {
        viewModelScope.launch {
            storage.setBalance(balance)
        }
    }
}