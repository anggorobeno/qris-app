package com.example.qrisapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.qrisapp.core.service.PromoService
import com.example.qrisapp.feature.porto.data.impl.PortoRepoImpl
import com.example.qrisapp.feature.porto.data.repo.PortoRepo
import com.example.qrisapp.feature.promo.data.impl.PromoRepoImpl
import com.example.qrisapp.feature.promo.data.repo.PromoRepo
import com.example.qrisapp.feature.qrisscanner.data.impl.QrRepoImpl
import com.example.qrisapp.feature.qrisscanner.data.repo.QrRepo
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(produceNewData = { emptyPreferences() }),
            produceFile = { context.preferencesDataStoreFile(StorageHelper.DATA) })
    }

    @Provides
    fun provideQrRepo(scanner: GmsBarcodeScanner): QrRepo {
        return QrRepoImpl(scanner)
    }

    @Provides
    fun providePromoRepo(apiService: PromoService): PromoRepo {
        return PromoRepoImpl(apiService)
    }

    @Provides
    fun providePortoRepo(): PortoRepo {
        return PortoRepoImpl()
    }
}