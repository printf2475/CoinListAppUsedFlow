package com.example.coin_list_app_used_flow.domain.useCase

import com.example.coin_list_app_used_flow.domain.model.CoinData
import com.example.coin_list_app_used_flow.domain.repository.CoinRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class UseCaseNewsList @Inject constructor(private val coinRepository: CoinRepository) {

    suspend fun loadCoinList() = coroutineScope {
        val coinDataList = mutableListOf<CoinData>()
        val coinList = async { coinRepository.loadCoinList() }
        val coinAssetsStatus = async { coinRepository.loadAssetsStatus() }

        val coinDataTempList = coinList.await().toCoinDataList()
        val coinAssetsStatusDataList = coinAssetsStatus.await().toCoinAssetsStatusData()
        for (i in coinDataTempList.indices){
            val coinData = coinDataTempList[i].copy(deposit_status = coinAssetsStatusDataList[i].deposit_status,
                withdrawal_status = coinAssetsStatusDataList[i].withdrawal_status)

            coinDataList.add(coinData)
        }

        coinDataList
    }
}