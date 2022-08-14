package com.example.coin_list_app_used_flow.data.remote.restApi

import com.example.coin_list_app_used_flow.BuildConfig
import com.example.coin_list_app_used_flow.data.model.CoinAssetsStatusList
import com.example.coin_list_app_used_flow.data.model.CoinList
import com.example.coin_list_app_used_flow.data.model.ResultSearchNews
import retrofit2.http.*


interface NewsRestApi {
    @GET("search/news.json")
    suspend fun loadNewsList(
        @Header("X-Naver-Client-Id") clientId: String? = BuildConfig.CLIENT_ID,
        @Header("X-Naver-Client-Secret") clientSecret: String? = BuildConfig.CLIENT_SECRET,
        @Query("query", encoded = true) searchString : String,
        @Query("sort") sort : String?= "date",
        @Query("display") display : Int?= 30
    ): ResultSearchNews


}