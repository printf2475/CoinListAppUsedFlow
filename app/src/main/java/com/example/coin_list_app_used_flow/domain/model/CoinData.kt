package com.example.coin_list_app_used_flow.domain.model

data class CoinData(
    val coinName: String?="",
    val closing_price: String?,
    val units_traded: String?,
    val deposit_status: Int =0,
    val withdrawal_status: Int =0
)
