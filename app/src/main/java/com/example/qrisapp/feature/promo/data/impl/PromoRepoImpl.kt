package com.example.qrisapp.feature.promo.data.impl

import com.example.qrisapp.core.network.util.Resource
import com.example.qrisapp.core.service.PromoService
import com.example.qrisapp.feature.promo.data.repo.PromoRepo
import com.example.qrisapp.feature.promo.data.response.PromoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PromoRepoImpl(private val api: PromoService) : PromoRepo {
    override fun getPromos(): Flow<Resource<List<PromoResponse>>> {
        return flow {
            emit(Resource.Loading)
            try {
                val response = api.getPromos()
                emit(Resource.Success(response))
            } catch (e: Throwable) {
                emit(Resource.Error(Throwable()))
            }
        }.flowOn(Dispatchers.IO)
    }
}