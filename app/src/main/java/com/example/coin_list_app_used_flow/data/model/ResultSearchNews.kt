package com.example.coin_list_app_used_flow.data.model

import com.example.coin_list_app_used_flow.domain.model.NewsItem

data class ResultSearchNews(
    var lastBuildDate: String = "",
    var total: Int = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: List<NewsItems>
){
    fun toNewsItemList() :  List<NewsItem> = items.map {
        NewsItem(it.title, it.description, it.pubDate)
    }
}

data class NewsItems (
    var title: String = "",
    var originallink: String = "",
    var link: String = "",
    var description: String = "",
    var pubDate: String = ""
)