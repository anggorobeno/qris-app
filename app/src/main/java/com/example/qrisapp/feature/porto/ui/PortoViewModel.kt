package com.example.qrisapp.feature.porto.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrisapp.core.network.util.Resource
import com.example.qrisapp.feature.porto.data.model.PortoUiModel
import com.example.qrisapp.feature.porto.data.repo.PortoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PortoViewModel @Inject constructor(
    private val repository: PortoRepo
) : ViewModel() {
    private val _porto = MutableStateFlow<Resource<PortoUiModel>>(Resource.Default)
    val porto = _porto.asStateFlow()

    init {
        getPorto()
    }

    private fun getPorto() = viewModelScope.launch {
        repository.getPorto().collect {
            _porto.value = it
        }
    }
}