package com.example.qrisapp.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class UrlInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url.encodedPath
        val isTranslation = url.contains(TRANSLATION)
        val isAsset = url.contains(ASSET)
        val isWcms = isTranslation || isAsset
        val newUrl =
            if (isTranslation) {
                TRANSLATION_URL
            } else if (isAsset) {
                ASSET_URL
            } else {
                ""
            }

        return if (isWcms) {
            val newRequest = chain
                .request()
                .newBuilder()
                .url(newUrl)
                .build()
            chain.proceed(newRequest)
        } else {
            chain.proceed(chain.request())
        }
    }

    companion object {
        private const val TRANSLATION = "translation"
        private const val ASSET = "asset"
        private const val TRANSLATION_URL =
            "https://tdwstcontent.telkomsel.com/api/translation/all/mobile"
        private const val ASSET_URL =
            "https://tdwstcontent.telkomsel.com/api/v1/asset/mobile"
    }
}