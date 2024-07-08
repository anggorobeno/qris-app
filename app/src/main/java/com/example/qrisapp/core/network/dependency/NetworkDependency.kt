package com.example.qrisapp.core.network.dependency

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.example.qrisapp.core.network.interceptor.UrlInterceptor
import com.example.qrisapp.core.service.QRISService
import com.example.qrisapp.core.network.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkDependency {
    fun provideNetwork(context: Context): QRISService {
        val chuckerCollector =
            ChuckerCollector(context, true, RetentionManager.Period.ONE_HOUR)

        val chuckerInterceptor =
            ChuckerInterceptor
                .Builder(context)
                .collector(chuckerCollector)
                .build()

        val urlInterceptor = UrlInterceptor()

        val okHttpClient =
            OkHttpClient
                .Builder()
                .addInterceptor(chuckerInterceptor)
                .addInterceptor(urlInterceptor)
                .build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val qrisService = retrofit.create(QRISService::class.java)

        return qrisService
    }
}