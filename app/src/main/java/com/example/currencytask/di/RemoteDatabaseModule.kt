package com.example.currencytask.di

import com.example.currencytask.data.remote.api.CurrencyApi
import com.example.currencytask.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDatabaseModule {


    @[Provides Singleton]
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCurrencyApi(retrofit: Retrofit):CurrencyApi =retrofit.create(CurrencyApi::class.java)
}