package com.example.qrisapp.core.network.util

sealed class Resource<out T> {
    object Default : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val throwable: Throwable) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}