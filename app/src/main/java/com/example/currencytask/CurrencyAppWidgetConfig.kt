package com.example.currencytask

import android.appwidget.AppWidgetManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RemoteViews
import com.example.currencytask.service.ExampleWidgetService

class CurrencyAppWidgetConfig : AppCompatActivity() {

    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_app_widget_config)
    }


    fun confirmConfiguration(view:View){
        var appWidgetManager = AppWidgetManager.getInstance(this)

        var serviceIntent = Intent(this,ExampleWidgetService::class.java)
        serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetId)
        serviceIntent.data = Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME))

        var views = RemoteViews(this.packageName,R.layout.currency_widget)
        views.setRemoteAdapter(R.id.currency_widget_stack_view,serviceIntent)

        appWidgetManager.updateAppWidget(appWidgetId,views)
    }
}