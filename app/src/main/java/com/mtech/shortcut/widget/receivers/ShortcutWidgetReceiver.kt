package com.mtech.shortcut.widget.receivers

import android.appwidget.AppWidgetManager
import android.content.Context
import android.util.Log
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.mtech.shortcut.widget.ui.widgets.ShortcutWidget


class ShortcutWidgetReceiver: GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = ShortcutWidget()

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        Log.d("TAG", "ShortcutWidgetReceiver: id")
        Log.d("TAG", "ShortcutWidgetReceiver: id${appWidgetIds.toList()}")

    }
}