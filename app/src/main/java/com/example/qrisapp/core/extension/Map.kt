package com.example.qrisapp.core.extension

import timber.log.Timber

fun <T, U> List<T>.mapSafe(
    action: (T) -> U
): List<U> {
    return this.mapNotNull { data ->
        try {
            action(data)
        } catch (error: Throwable) {
            Timber.d("mapSafe: $error")
            null
        }
    }.ifEmpty {
        throw Exception("Empty")
    }
}