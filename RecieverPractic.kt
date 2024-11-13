package com.example.practicaltest01var05

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class RecieverPractic : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val message = intent.getStringExtra("message")
        Log.d("MyBroadcastReceiver", "Received message: $message")
    }
}