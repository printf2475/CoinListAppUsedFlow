package com.example.coin_list_app_used_flow.domain.repository

import com.example.coin_list_app_used_flow.data.model.CoinAssetsStatusList
import com.example.coin_list_app_used_flow.data.model.CoinList

interface CoinRepository {
    suspend fun loadCoinList(): CoinList
    suspend fun loadAssetsStatus(): CoinAssetsStatusList
}