package com.example.qrisapp.feature.promo.data.response

import android.media.Image
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PromoResponse(

    @field:SerializedName("img")
    val img: Image? = null,

    @field:SerializedName("latitude")
    val latitude: String? = null,

    @field:SerializedName("alt")
    val alt: String? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("lokasi")
    val lokasi: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("published_at")
    val publishedAt: String? = null,

    @field:SerializedName("desc")
    val desc: String? = null,

    @field:SerializedName("longitude")
    val longitude: String? = null
) : Parcelable {
    @Parcelize
    data class Image(

        @field:SerializedName("ext")
        val ext: String? = null,

        @field:SerializedName("formats")
        val formats: Formats? = null,

        @field:SerializedName("mime")
        val mime: String? = null,

        @field:SerializedName("caption")
        val caption: String? = null,

        @field:SerializedName("created_at")
        val createdAt: String? = null,

        @field:SerializedName("url")
        val url: String? = null,

        @field:SerializedName("updated_at")
        val updatedAt: String? = null,

        @field:SerializedName("provider")
        val provider: String? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("alternativeText")
        val alternativeText: String? = null,

        @field:SerializedName("hash")
        val hash: String? = null,

        @field:SerializedName("height")
        val height: Int? = null
    ) : Parcelable {
        @Parcelize
        data class Formats(
            @field:SerializedName("medium")
            val medium: Medium? = null
        ) : Parcelable {
            @Parcelize
            data class Medium(

                @field:SerializedName("ext")
                val ext: String? = null,

                @field:SerializedName("mime")
                val mime: String? = null,

                @field:SerializedName("name")
                val name: String? = null,

                @field:SerializedName("width")
                val width: Int? = null,

                @field:SerializedName("url")
                val url: String? = null,

                @field:SerializedName("hash")
                val hash: String? = null,

                @field:SerializedName("height")
                val height: Int? = null
            ) : Parcelable
        }
    }
}