package com.example.coin_list_app_used_flow.data.remote.restApi

import com.example.coin_list_app_used_flow.data.model.CoinAssetsStatusList
import com.example.coin_list_app_used_flow.data.model.CoinList
import retrofit2.http.*

interface CoinRestApi {


    @GET("ticker/ALL_KRW")
    suspend fun loadCoinList(): CoinList

    @GET("assetsstatus/ALL")
    suspend fun loadAssetsStatusList(): CoinAssetsStatusList

}