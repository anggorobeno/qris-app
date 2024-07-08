package com.example.qrisapp.di

import com.example.qrisapp.feature.qrisscanner.QrisViewModel
import com.example.qrisapp.feature.qrisscanner.data.api.QrRepo
import com.example.qrisapp.feature.qrisscanner.data.impl.QrRepoImpl
import com.example.qrisapp.feature.qrisscanner.dependency.ScannerDependency
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val scannerModule = module {
    single {
        ScannerDependency.provideBarCodeOptions()
        ScannerDependency.provideBarCodeScanner(androidContext(), get())
    }
}

val dataModule = module {
    single<QrRepo> {
        QrRepoImpl(
            get()
        )
    }
}

val viewModelModule = module {
    viewModel { QrisViewModel(get<QrRepo>()) }
}