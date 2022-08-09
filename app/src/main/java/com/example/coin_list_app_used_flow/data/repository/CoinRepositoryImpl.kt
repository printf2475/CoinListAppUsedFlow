package com.example.coin_list_app_used_flow.data.repository

import com.example.coin_list_app_used_flow.data.model.CoinAssetsStatusList
import com.example.coin_list_app_used_flow.data.model.CoinList
import com.example.coin_list_app_used_flow.data.remote.restApi.CoinRestApi
import com.example.coin_list_app_used_flow.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val coinRestApi: CoinRestApi): CoinRepository {

    override suspend fun loadCoinList(): CoinList =coinRestApi.loadCoinList()


    override suspend fun loadAssetsStatus(): CoinAssetsStatusList = coinRestApi.loadAssetsStatusList()
}