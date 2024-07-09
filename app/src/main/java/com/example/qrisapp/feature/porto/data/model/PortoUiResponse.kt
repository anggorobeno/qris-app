package com.example.qrisapp.feature.porto.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PortoUiResponse(
    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("data")
    val lineData: LineChartData? = null
) : Parcelable {

    @Parcelize
    data class DataItem(
        @field:SerializedName("label")
        val label: String? = null,

        @field:SerializedName("percentage")
        val percentage: String? = null,

        @field:SerializedName("data")
        val data: List<TransactionItem?>? = null
    ) : Parcelable {

        @Parcelize
        data class TransactionItem(
            @field:SerializedName("trx_date")
            val trxDate: String? = null,

            @field:SerializedName("nominal")
            val nominal: Int? = null
        ) : Parcelable
    }

    @Parcelize
    data class LineChartData(
        @field:SerializedName("month")
        val month: List<Int?>? = null
    ) : Parcelable

}