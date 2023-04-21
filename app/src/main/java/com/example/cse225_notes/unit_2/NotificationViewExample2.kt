package com.example.cse225_notes.unit_2

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.cse225_notes.R

class NotificationViewExample2 : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_view_example)

        var txtView = findViewById<TextView>(R.id.viewNotification)
        var inp = NotificationManagerExample2()
        var bundle: Bundle = RemoteInput.getResultsFromIntent(intent)
        if (bundle != null) {
            txtView.setText(bundle.getString(inp.myKey))
            notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.cancel(inp.notificationId)
        }
    }
}