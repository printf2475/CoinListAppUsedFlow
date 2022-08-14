package com.example.coin_list_app_used_flow.domain.model

data class NewsItem(
    var title: String = "",
    var description: String = "",
    var pubDate: String = ""
):Comparable<NewsItem> {
    override fun compareTo(other: NewsItem): Int {
        return this.pubDate.compareTo(other.pubDate)
    }
}
