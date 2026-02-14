package com.mtech.shortcut.widget.ui.widgets

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.core.content.ContextCompat.startActivity
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Column

class ShortcutWidget: GlanceAppWidget() {
    override val sizeMode = SizeMode.Exact


    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            Column {
                Button(
                    "Go to Developer Setting",
                    onClick = {
                        val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS).apply {
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        }
                        context.startActivity(intent)
                })
            }
        }
    }
}
