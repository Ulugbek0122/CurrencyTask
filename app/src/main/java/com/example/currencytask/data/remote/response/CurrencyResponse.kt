package com.example.currencytask.data.remote.response

data class CurrencyResponse(
    var id:Int,
    var Code:String,
    var Ccy:String,
    var CcyNm_RU:String,
    var CcyNm_UZ:String,
    var CcyNm_UZC:String,
    var CcyNm_EN:String,
    var Nominal:String,
    var Rate:String,
    var Diff:String,
    var Date:String
)