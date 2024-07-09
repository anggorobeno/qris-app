package com.example.qrisapp.feature.porto.data.repo

import com.example.qrisapp.core.network.util.Resource
import com.example.qrisapp.feature.porto.data.model.PortoUiModel
import kotlinx.coroutines.flow.Flow

interface PortoRepo {
    fun getPorto(): Flow<Resource<PortoUiModel>>
}