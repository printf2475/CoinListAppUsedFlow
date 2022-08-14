package com.example.coin_list_app_used_flow.di

import com.example.coin_list_app_used_flow.data.remote.restApi.CoinRestApi
import com.example.coin_list_app_used_flow.data.remote.restApi.NewsRestApi
import com.example.coin_list_app_used_flow.data.repository.CoinRepositoryImpl
import com.example.coin_list_app_used_flow.data.repository.NewsRepositoryImpl
import com.example.coin_list_app_used_flow.domain.repository.CoinRepository
import com.example.coin_list_app_used_flow.domain.repository.NewsRepository
import com.example.coin_list_app_used_flow.domain.useCase.UseCaseCoinList
import com.example.coin_list_app_used_flow.domain.useCase.UseCaseNewsList
import com.example.coin_list_app_used_flow.domain.useCase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinRepository(coinRestApi: CoinRestApi) : CoinRepository {
        return CoinRepositoryImpl(coinRestApi)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsRestApi: NewsRestApi) : NewsRepository {
        return NewsRepositoryImpl(newsRestApi)
    }



    @Provides
    @Singleton
    fun provideUseCases(coinRepository: CoinRepository, newsRepository: NewsRepository): UseCases {
        return UseCases(
            loadCoinList = UseCaseCoinList(coinRepository),
            loadNewsList = UseCaseNewsList(newsRepository)

        )
    }

}