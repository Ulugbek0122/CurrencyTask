package com.example.currencytask

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import com.example.currencytask.service.ExampleWidgetService


class CurrencyWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        for (appWidgetId in appWidgetIds!!) {

            var intent = Intent(context,MainActivity::class.java)
            var pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )

            var serviceIntent = Intent(context, ExampleWidgetService::class.java)
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            serviceIntent.data = Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME))

            var views = RemoteViews(context!!.packageName,R.layout.currency_widget)
            views.setRemoteAdapter(R.id.currency_widget_stack_view,serviceIntent)

            appWidgetManager!!.updateAppWidget(appWidgetId,views)
        }
    }
}