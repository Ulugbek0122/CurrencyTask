package com.example.currencytask.repository.impl

import android.content.Context
import com.example.currencytask.data.remote.api.CurrencyApi
import com.example.currencytask.data.remote.response.CurrencyResponse
import com.example.currencytask.repository.CurrencyRepository
import com.example.currencytask.utils.MessageData
import com.example.currencytask.utils.ResultData
import com.example.currencytask.utils.hasConnection
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private var api: CurrencyApi
): CurrencyRepository {


    override fun getCurrency(): Flow<List<CurrencyResponse>> = flow {
        if (hasConnection(context)) {
            val response = api.getCurrency()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null){
                    emit(body)
                }
            }
        }
    }.flowOn(Dispatchers.IO)

//
//    override fun getCurrency(): List<CurrencyResponse> {
//        api.getCurrency().enqueue(obje)
//    }
}