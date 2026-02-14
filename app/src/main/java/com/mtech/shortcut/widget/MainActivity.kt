package com.mtech.shortcut.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mtech.shortcut.widget.receivers.AddToHomeReceiver
import com.mtech.shortcut.widget.receivers.ShortcutWidgetReceiver
import com.mtech.shortcut.widget.ui.theme.ShortCutWidgetTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val ACTION_PINNED_SUCCESS = "ACTION_PINNED_SUCCESS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShortCutWidgetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Button(
                        onClick = {
                            requestPinMyWidget()
                        },
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Text("Add Widget")
                    }
                }
            }
        }
    }

    private fun requestPinMyWidget() {
        val appWidgetManager = AppWidgetManager.getInstance(this)
        val myProvider = ComponentName(this, ShortcutWidgetReceiver::class.java)

        Log.d("TAG", "onCreate: requestPinMyWidget")
        val successCallback = PendingIntent.getBroadcast(
            this,
            0,
            Intent(this, AddToHomeReceiver::class.java).apply {
                action = ACTION_PINNED_SUCCESS
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
        )

        if (appWidgetManager.isRequestPinAppWidgetSupported) {
            Log.d("TAG", "onCreate: isRequestPinAppWidgetSupported")
            val result = appWidgetManager.requestPinAppWidget(
                myProvider,
                null,
                successCallback
            )
            Log.d("TAG", "onCreate: ${result}")
        } else {
            Log.d("TAG", "onCreate: fallback")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShortCutWidgetTheme {
        Greeting("Android")
    }
}