package com.example.coin_list_app_used_flow.domain.useCase

import android.util.Log
import com.example.coin_list_app_used_flow.data.model.CoinAssetsStatusList
import com.example.coin_list_app_used_flow.data.model.CoinList
import com.example.coin_list_app_used_flow.domain.model.CoinAssetsStatusData
import com.example.coin_list_app_used_flow.domain.model.CoinData
import com.example.coin_list_app_used_flow.domain.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class UseCaseCoinList @Inject constructor(private val coinRepository: CoinRepository) {


    suspend fun loadCoinList(): Flow<MutableList<CoinData>> {
        val coinDataList = mutableListOf<CoinData>()

        //코인 이름, 코인 가격
        val coinDataTempList = flow {
            while (true) {
                emit(coinRepository.loadCoinList().toCoinDataList())
                delay(10000)
            }
        }.flowOn(Dispatchers.IO)

        //코인 거래가능 현황
        val coinAssetsStatus = flow {
            while (true) {
                emit(coinRepository.loadAssetsStatus().toCoinAssetsStatusData())
                delay(10000)
            }
        }.flowOn(Dispatchers.IO)


        return coinDataTempList.zip(coinAssetsStatus) { coindata, coinAssetStateList ->
            for (i in coindata.indices) {
                coinAssetStateList.forEach {
                    if (it.coinName == coindata[i].coinName) {
                        val coinData = coindata[i].copy(
                            deposit_status = it.deposit_status,
                            withdrawal_status = it.withdrawal_status
                        )
                        coinDataList.add(coinData)
                    }
                }
            }

            coinDataList
        }


    }
}