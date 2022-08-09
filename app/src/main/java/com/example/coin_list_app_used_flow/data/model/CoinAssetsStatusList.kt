package com.example.coin_list_app_used_flow.data.model

import com.example.coin_list_app_used_flow.domain.model.CoinAssetsStatusData

data class CoinAssetsStatusList(
    val `data`: HashMap<String, CoinBuyAndSellStatus>,
    val status: String
) {
    fun toCoinAssetsStatusData(): List<CoinAssetsStatusData> = data.map { (coinName, coinBuyAndSellStatus) ->
        CoinAssetsStatusData(coinName, coinBuyAndSellStatus.deposit_status, coinBuyAndSellStatus.withdrawal_status)
    }
}