package com.example.cse225_notes.unit_2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cse225_notes.R

class NotificationManagerExample : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    var channelId = "My Channel"
    val notificationId = 1234
    var title = "Notification"
    var description = "Test My Notification"

    lateinit var bt: Button
    lateinit var pendingIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_manager_example)

        bt = findViewById<Button>(R.id.sendNotification)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        bt.setOnClickListener {
            val intent = Intent(this, NotificationViewExample::class.java)
            pendingIntent = PendingIntent.getActivity(
                this, 0,
                intent, FLAG_IMMUTABLE
            )

            createYourChannel()
            notificationManager.notify(notificationId, builder.build())
        }
    }

    fun createYourChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(
                channelId, description,
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
            notificationChannel.lightColor = Color.GREEN
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelId)
                .setSmallIcon(androidx.appcompat.R.drawable.abc_ic_arrow_drop_right_black_24dp)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        this.resources,
                        androidx.appcompat.R.drawable.abc_list_longpressed_holo
                    )
                )
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        } else {
            builder = Notification.Builder(this)
                .setSmallIcon(androidx.appcompat.R.drawable.abc_ic_arrow_drop_right_black_24dp)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        this.resources,
                        androidx.appcompat.R.drawable.abc_list_longpressed_holo
                    )
                )
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
    }
}