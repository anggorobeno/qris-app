package com.example.qrisapp.core.service

import com.example.qrisapp.feature.promo.data.response.PromoResponse
import retrofit2.http.GET

interface PromoService {
    @GET("promos")
    suspend fun getPromos(): List<PromoResponse>
}