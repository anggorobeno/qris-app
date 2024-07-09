package com.example.qrisapp.core.extension

import com.example.qrisapp.feature.porto.data.model.PortoUiResponse

val dummyPorto = listOf(
    PortoUiResponse(
        type = "donutChart",
        data = listOf(
            PortoUiResponse.DataItem(
                label = "Tarik Tunai",
                percentage = "54",
                data = listOf(
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "21/01/2023",
                        nominal = 1000000
                    ),
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "20/01/2023",
                        nominal = 500000
                    ),
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "19/01/2023",
                        nominal = 1000000
                    )
                )
            ),
            PortoUiResponse.DataItem(
                label = "QRIS Payment",
                percentage = "32",
                data = listOf(
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "21/01/2023",
                        nominal = 159000
                    ),
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "20/01/2023",
                        nominal = 35000
                    ),
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "19/01/2023",
                        nominal = 1500
                    )
                )
            ),
            PortoUiResponse.DataItem(
                label = "Topup Gopay",
                percentage = "7.7",
                data = listOf(
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "21/01/2023",
                        nominal = 200000
                    ),
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "20/01/2023",
                        nominal = 195000
                    ),
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "19/01/2023",
                        nominal = 5000000
                    )
                )
            ),
            PortoUiResponse.DataItem(
                label = "Lainnya",
                percentage = "6.3",
                data = listOf(
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "21/01/2023",
                        nominal = 1000000
                    ),
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "20/01/2023",
                        nominal = 500000
                    ),
                    PortoUiResponse.DataItem.TransactionItem(
                        trxDate = "19/01/2023",
                        nominal = 1000000
                    )
                )
            )
        )
    ),
    PortoUiResponse(
        type = "lineChart",
        lineData = PortoUiResponse.LineChartData(
            month = listOf(3, 7, 8, 10, 5, 10, 1, 3, 5, 10, 7, 7)
        )
    )
)