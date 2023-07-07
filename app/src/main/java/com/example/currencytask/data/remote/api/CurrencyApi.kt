package com.example.currencytask.data.remote.api

import com.example.currencytask.data.remote.response.BaseResponse
import com.example.currencytask.data.remote.response.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {

    @GET("arkhiv-kursov-valyut/json/")
    suspend fun getCurrency():Response<List<CurrencyResponse>>
}