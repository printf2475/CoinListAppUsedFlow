package com.example.coin_list_app_used_flow.domain.model

data class CoinAssetsStatusData(
    val coinName: String,
    val deposit_status: Int,
    val withdrawal_status: Int
)
