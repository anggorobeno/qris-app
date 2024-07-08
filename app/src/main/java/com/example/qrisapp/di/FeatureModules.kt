package com.example.qrisapp.di

import org.koin.dsl.koinApplication

object FeatureModules {
    val featureModules = listOf(
        networkModule,
        scannerModule,
        dataModule,
        viewModelModule
    )

    object IsolatedKoinContext {
        val koinApp = koinApplication {
            modules(featureModules)
        }
    }
}