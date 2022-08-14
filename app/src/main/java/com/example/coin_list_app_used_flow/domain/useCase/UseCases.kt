package com.example.coin_list_app_used_flow.domain.useCase

import javax.inject.Inject

data class UseCases @Inject constructor(
    val loadCoinList: UseCaseCoinList,
    val loadNewsList: UseCaseNewsList,

)
