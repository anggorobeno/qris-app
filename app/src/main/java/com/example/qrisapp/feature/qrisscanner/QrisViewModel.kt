package com.example.qrisapp.feature.qrisscanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrisapp.core.extension.state
import com.example.qrisapp.feature.qrisscanner.data.api.QrRepo
import com.example.qrisapp.core.extension.asFlow
import com.example.qrisapp.core.extension.state
import com.example.qrisapp.feature.qrisscanner.data.model.ScannerModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QrisViewModel(val repo: QrRepo) : ViewModel() {
    private val _state = MutableStateFlow(ScannerModel())
    val state = _state.asStateFlow()
    val scannerState = repo.startScanning().state(viewModelScope, "")
    fun startScanning(){
        viewModelScope.launch {
            repo.startScanning().collect{
                if (!it.isNullOrBlank()){
                    _state.value = state.value.copy(
                        details = it
                    )
                }
            }
        }
    }
}