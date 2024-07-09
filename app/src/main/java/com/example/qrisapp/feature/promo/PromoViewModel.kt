package com.example.qrisapp.feature.promo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrisapp.core.network.util.Resource
import com.example.qrisapp.feature.promo.data.repo.PromoRepo
import com.example.qrisapp.feature.promo.data.response.PromoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor(private val repository: PromoRepo) : ViewModel() {
    private val _getPromos = MutableStateFlow<Resource<List<PromoResponse>>>(Resource.Default)
    val getPromos = _getPromos.asStateFlow()

    init {
        getPromos()
    }

    fun getPromos() = viewModelScope.launch {
        repository.getPromos().collect {
            _getPromos.value = it
        }
    }
}
