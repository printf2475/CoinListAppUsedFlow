package com.example.coin_list_app_used_flow.data.remote.restApi

import com.example.coin_list_app_used_flow.data.model.CoinAssetsStatusList
import com.example.coin_list_app_used_flow.data.model.CoinList
import retrofit2.http.*

interface CoinRestApi {

    @FormUrlEncoded
    @POST("ticker/ALL_KRW")
    suspend fun loadCoinList(@Field("asd") empty : String = ""): CoinList

    @FormUrlEncoded
    @POST("assetsstatus/ALL")
    suspend fun loadAssetsStatusList(@Field("asd") empty : String = ""): CoinAssetsStatusList

}