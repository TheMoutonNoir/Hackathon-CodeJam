package com.example.akademos

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService

class AlarmReceiver: BroadcastReceiver() {
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelId = "POMODORO"
    private val description = "PROMODORO TIMER"

    override fun onReceive(context: Context?, intent: Intent?) {
        createNotificationChannel(intent?.extras?.get("Message").toString(),context)
    }
    private fun createNotificationChannel(message: String, context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, description, importance)
            builder = Notification.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("WAKEY WAKEY")
                .setContentText(message)
            notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(100, builder.build())
    }
}