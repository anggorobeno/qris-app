package com.example.qrisapp.core.extension

fun <T, U> List<T>.mapSafe(
    action: (T) -> U
): List<U> {
    return this.mapNotNull { data ->
        try {
            action(data)
        } catch (error: Throwable) {
            printLog("mapSafe: $error")
            null
        }
    }.ifEmpty {
        throw Exception("Empty")
    }
}