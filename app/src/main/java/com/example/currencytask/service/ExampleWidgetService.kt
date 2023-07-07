package com.example.currencytask.service

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.example.currencytask.R
import com.example.currencytask.data.remote.response.CurrencyResponse
import com.example.currencytask.repository.CurrencyRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ExampleWidgetService @Inject constructor(
    private val repository: CurrencyRepository
): RemoteViewsService() {


    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
        return CurrencyWidgetItemFactory(applicationContext,p0!!,repository)
    }

    class CurrencyWidgetItemFactory(
        private val context: Context,
        intent: Intent,
        private val repository: CurrencyRepository
    ):RemoteViewsFactory{

        private var appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
        AppWidgetManager.INVALID_APPWIDGET_ID)

        override fun onCreate() {

        }

        override fun onDataSetChanged() {

        }

        override fun onDestroy() {

        }

        override fun getCount(): Int{
            var n = 0
            var currency:List<CurrencyResponse> = ArrayList()
            CoroutineScope(Dispatchers.Main).launch {
                repository.getCurrency().collectLatest {
                    currency = it
                }
            }
            if (currency.isNotEmpty()){
                n = currency.size
            }
            return n
        }


        override fun getViewAt(p0: Int): RemoteViews {
            var currency:List<CurrencyResponse> = ArrayList()
            CoroutineScope(Dispatchers.Main).launch {
                repository.getCurrency().collectLatest {
                    currency = it
                }
            }
            var views = RemoteViews(context.packageName, R.layout.currency_widget_item)
            if (currency.isNotEmpty()){
                views.setTextViewText(R.id.name_state,currency[p0].Ccy)
                views.setTextViewText(R.id.currency_text,currency[p0].Rate)
                views.setTextViewText(R.id.currency_text_oluv,currency[p0].Rate)
                views.setTextViewText(R.id.currency_text_sotuv,currency[p0].Diff)
            }

            return views
        }

        override fun getLoadingView(): RemoteViews {
            TODO("Not yet implemented")
        }

        override fun getViewTypeCount(): Int {
           return 1
        }

        override fun getItemId(p0: Int): Long {
            return  p0.toLong()
        }

        override fun hasStableIds(): Boolean {
            return true
        }

    }
}