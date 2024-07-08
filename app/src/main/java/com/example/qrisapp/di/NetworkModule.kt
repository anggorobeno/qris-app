package com.example.qrisapp.di

import android.content.Context
import com.example.qrisapp.core.network.dependency.NetworkDependency
import com.example.qrisapp.core.service.QRISService
import com.example.qrisapp.feature.qrisscanner.data.api.QrRepo
import com.example.qrisapp.feature.qrisscanner.data.impl.QrRepoImpl
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideNetwork(@ApplicationContext context: Context): QRISService {
        return NetworkDependency.provideNetwork(context)
    }
}