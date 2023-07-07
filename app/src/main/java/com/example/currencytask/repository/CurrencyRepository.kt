package com.example.currencytask.repository

import com.example.currencytask.data.remote.response.CurrencyResponse
import com.example.currencytask.utils.ResultData
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    fun getCurrency():Flow<List<CurrencyResponse>>
}