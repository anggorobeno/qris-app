package com.example.qrisapp.feature.porto.data.impl

import com.example.qrisapp.core.extension.dummyPorto
import com.example.qrisapp.core.extension.toPortoUiModel
import com.example.qrisapp.core.network.util.Resource
import com.example.qrisapp.feature.porto.data.model.PortoUiModel
import com.example.qrisapp.feature.porto.data.repo.PortoRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PortoRepoImpl(): PortoRepo {
    override fun getPorto(): Flow<Resource<PortoUiModel>> {
        return flow {
            emit(Resource.Loading)
            try {
                val response = toPortoUiModel(dummyPorto)
                emit(Resource.Success(response))
            } catch (e: Throwable) {
                emit(Resource.Error(Throwable()))
            }
        }.flowOn(Dispatchers.IO)
    }
}