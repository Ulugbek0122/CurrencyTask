package com.example.currencytask.data.remote.response

data class BaseResponse<T>(
    val message:String,
    val data:T?
)