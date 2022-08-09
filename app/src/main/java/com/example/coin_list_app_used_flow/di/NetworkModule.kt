package com.example.coin_list_app_used_flow.di

import com.example.coin_list_app_used_flow.BuildConfig
import com.example.coin_list_app_used_flow.data.remote.restApi.CoinRestApi
import com.example.coin_list_app_used_flow.data.remote.restApi.NewsRestApi
import com.example.coin_list_app_used_flow.util.Define
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideCoinBaseUrl(): String = BuildConfig.COIN_BASE_URL

    @Provides
    fun provideNewsBaseUrl(): String = BuildConfig.NEWS_BASE_URL


    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()


    @Singleton
    @Provides
    fun provideCoinRetrofit(okHttpClient: OkHttpClient): CoinRestApi=
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(provideCoinBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinRestApi::class.java)



    @Singleton
    @Provides
    fun provideNewsRetrofit(okHttpClient: OkHttpClient): NewsRestApi=
         Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(provideNewsBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsRestApi::class.java)


}