package com.example.coin_list_app_used_flow.domain.useCase

import com.example.coin_list_app_used_flow.data.model.NewsItems
import com.example.coin_list_app_used_flow.domain.model.NewsItem
import com.example.coin_list_app_used_flow.domain.repository.NewsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.util.*
import javax.inject.Inject

class UseCaseNewsList @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun loadNewsList() = coroutineScope {
        val newsList = mutableListOf<NewsItem>()
        val coinNewsList = async { newsRepository.loadNews("coin").toNewsItemList() }
        val nftNewsList = async { newsRepository.loadNews("nft").toNewsItemList()  }

        newsList.addAll(coinNewsList.await())
        newsList.addAll(nftNewsList.await())

        newsList.sortDescending()

        newsList
    }
}