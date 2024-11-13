package com.example.practicaltest01var05

import android.app.Service
import android.app.Service.START_STICKY
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.enableEdgeToEdge
import java.util.logging.Handler

class ServicePractic : Service() {
    private val handler = android.os.Handler()
    private lateinit var broadcastIntent: Intent
    private val interval: Long = 5000

    private val runnable = object : Runnable {
        override fun run() {
            Log.d("MyService", "Broadcasting message")
            sendBroadcast(broadcastIntent)
            handler.postDelayed(this, interval)
        }
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        handler.post(runnable)  // Start the periodic broadcast
        broadcastIntent = Intent()
        broadcastIntent.action = "ro.pub.cs.systems.eim.practicaltest01var05.broadcast"
        broadcastIntent.putExtra("message", intent?.getStringExtra("text_view"))
        return START_STICKY  // Keep running until explicitly stopped
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)  // Stop the periodic task
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}