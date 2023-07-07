package com.example.currencytask.di

import com.example.currencytask.repository.CurrencyRepository
import com.example.currencytask.repository.impl.CurrencyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCurrencyRepository(impl:CurrencyRepositoryImpl):CurrencyRepository
}