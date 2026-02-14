package com.mtech.shortcut.widget.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.mtech.shortcut.widget.MainActivity

class AddToHomeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("TAG", "onReceive: ${intent.action}")
        Log.d("TAG", "onReceive: $intent")
        if (intent.action == MainActivity.ACTION_PINNED_SUCCESS) {
            Toast.makeText(context, "Widget pinned!", Toast.LENGTH_SHORT).show()
        }
    }
}