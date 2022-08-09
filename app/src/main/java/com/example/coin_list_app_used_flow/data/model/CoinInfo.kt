package com.example.coin_list_app_used_flow.data.model


data class CoinInfo(
    val acc_trade_value: String,
    val acc_trade_value_24H: String,
    val closing_price: String?,
    val fluctate_24H: String,
    val fluctate_rate_24H: String,
    val max_price: String,
    val min_price: String,
    val opening_price: String,
    val prev_closing_price: String,
    val units_traded: String?,
    val units_traded_24H: String
)