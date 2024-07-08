package com.example.qrisapp.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import com.example.qrisapp.core.network.dependency.NetworkDependency.provideNetwork


val networkModule = module {
    single {
        provideNetwork(androidContext())
    }
}