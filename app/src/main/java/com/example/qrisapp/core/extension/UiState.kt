package com.example.qrisapp.core.extension

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

sealed interface UiState<out T> {
    object Init : UiState<Nothing>
    object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val error: Throwable? = null) : UiState<Nothing>
}

suspend fun <T> MutableStateFlow<UiState<T>>.asUiState(tag: String = "", action: suspend () -> T) {
    this.update { UiState.Loading }
    try {
        val data = action()
        this.update { UiState.Success(data) }
        printLog("asUiState -> $tag: $data")
    } catch (error: Throwable) {
        this.update { UiState.Error(error) }
        printLog("asUiState: -> $tag: $error")
    }
}

suspend fun <T> MutableSharedFlow<UiState<T>>.asUiState(tag: String = "", action: suspend () -> T) {
    this.emit(UiState.Loading)
    try {
        val data = action()
        this.emit(UiState.Success(data))
        printLog("asUiState -> $tag: $data")
    } catch (error: Throwable) {
        this.emit(UiState.Error(error))
        printLog("asUiState: -> $tag: $error")
    }
}

fun <T> asFlow(tag: String = "", action: suspend () -> T): Flow<T> {
    return callbackFlow {
        try {
            val data = action()
            send(data)
            printLog("asFlow -> $tag: $data")
            close()
        } catch (error: Throwable) {
            printLog("asFlow: -> $tag: $error")
            close()
        }
    }
}

fun <T> asFlowUiState(tag: String = "", action: suspend () -> T): Flow<UiState<T>> {
    return callbackFlow {
        send(UiState.Loading)
        printLog("asFlowUiState -> $tag: Loading")
        try {
            val data = action()
            send(UiState.Success(data))
            printLog("asFlowUiState -> $tag: $data")
            close()
        } catch (error: Throwable) {
            send(UiState.Error(error))
            printLog("asFlowUiState -> $tag: $error")
            close()
        }
    }
}

fun <T> Flow<UiState<T>>.uiState(scope: CoroutineScope): StateFlow<UiState<T>> {
    return this.stateIn(scope, SharingStarted.Lazily, UiState.Init)
}

fun <T> Flow<T>.state(scope: CoroutineScope, default: T): StateFlow<T> {
    return this.stateIn(scope, SharingStarted.Lazily, default)
}

fun <T> Flow<UiState<T>>.uiShare(scope: CoroutineScope): SharedFlow<UiState<T>> {
    return this.shareIn(scope, SharingStarted.Lazily)
}

fun <T> Flow<T>.share(scope: CoroutineScope): SharedFlow<T> {
    return this.shareIn(scope, SharingStarted.Lazily)
}

inline fun <T> UiState<T>.onInit(action: () -> Unit): UiState<T> = apply {
    if (this is UiState.Init) {
        action()
    }
}

inline fun <T> UiState<T>.onLoading(action: () -> Unit): UiState<T> = apply {
    if (this is UiState.Loading) {
        action()
    }
}

inline fun <T> UiState<T>.onSuccess(action: (data: T) -> Unit): UiState<T> = apply {
    if (this is UiState.Success) {
        action(data)
    }
}

inline fun <T> UiState<T>.onError(action: (error: Throwable?) -> Unit): UiState<T> = apply {
    if (this is UiState.Error) {
        action(error)
    }
}