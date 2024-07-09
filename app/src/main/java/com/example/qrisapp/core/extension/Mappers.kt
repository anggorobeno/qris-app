package com.example.qrisapp.core.extension

import com.example.qrisapp.core.design.theme.Color_FDA22B
import com.example.qrisapp.feature.porto.data.model.DonutChartData
import com.example.qrisapp.feature.porto.data.model.PortoUiModel
import com.example.qrisapp.feature.porto.data.model.PortoUiResponse

fun toPortoUiModel(data: List<PortoUiResponse>): PortoUiModel {
    return PortoUiModel(
        donut = data.flatMap { portoUiModel ->
            portoUiModel.data?.mapNotNull { dataItem ->
                dataItem?.let { porto ->
                    DonutChartData(
                        amount = porto.percentage?.toFloatOrNull()?.times(10) ?: 0f,
                        color = porto.label?.formatColor() ?: Color_FDA22B,
                        title = porto.label.orEmpty(),
                        listData = porto.data?.mapNotNull { trx ->
                            DonutChartData.TransactionItem(
                                trxDate = trx?.trxDate.orEmpty().formatDate(),
                                nominal = trx?.nominal?.formatRupiah()?.replace(",00", "").orEmpty()
                            )
                        }.orEmpty()
                    )
                }
            } ?: emptyList()
        },
        line = PortoUiModel.LineChartData(month = data.flatMap {
            it.lineData?.month?.filterNotNull() ?: emptyList()
        })
    )
}