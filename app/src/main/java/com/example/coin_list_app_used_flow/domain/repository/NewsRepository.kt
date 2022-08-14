package com.example.coin_list_app_used_flow.domain.repository

import com.example.coin_list_app_used_flow.data.model.CoinAssetsStatusList
import com.example.coin_list_app_used_flow.data.model.CoinList
import com.example.coin_list_app_used_flow.data.model.ResultSearchNews

interface NewsRepository {

    suspend fun loadNews(searchString:String) : ResultSearchNews

}