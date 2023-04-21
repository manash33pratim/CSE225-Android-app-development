package com.example.cse225_notes.unit_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.cse225_notes.R

class SplashScreenExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_example)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val i = Intent(this, SplashScreenExampleMain::class.java)
                startActivity(i)
                finish()
            }, 5000
        )
    }
}