package com.example.qrisapp.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StorageHelper @Inject constructor(private val dataStore: DataStore<Preferences>) {
    companion object {
        const val DATA = "Data"
        private const val BALANCE = "Balance"

        val balance = longPreferencesKey(BALANCE)

    }
    fun getBalance(): Flow<Long> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map { preferences ->
            preferences[balance] ?: 0L
        }
    }

    suspend fun setBalance(userBalance: Long) {
        dataStore.edit { preference ->
            preference[balance] = userBalance
        }
    }
}