package com.example.qrisapp.feature.promo.data.repo

import com.example.qrisapp.core.network.util.Resource
import com.example.qrisapp.feature.promo.data.response.PromoResponse
import kotlinx.coroutines.flow.Flow

interface PromoRepo {
    fun getPromos(): Flow<Resource<List<PromoResponse>>>
}