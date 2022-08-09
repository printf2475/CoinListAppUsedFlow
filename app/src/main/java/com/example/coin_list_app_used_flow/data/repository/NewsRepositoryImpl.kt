package com.example.coin_list_app_used_flow.data.repository

import com.example.coin_list_app_used_flow.data.model.CoinAssetsStatusList
import com.example.coin_list_app_used_flow.data.model.CoinList
import com.example.coin_list_app_used_flow.data.remote.restApi.NewsRestApi
import com.example.coin_list_app_used_flow.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsRestApi: NewsRestApi): NewsRepository {

    override suspend fun loadCoinNews(): CoinList =newsRestApi.loadCoinList()

    override suspend fun loadNtfNews() : CoinAssetsStatusList = newsRestApi.loadAssetsStatusList()
}