package com.example.cse225_notes.unit_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CustomViewExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //For smiley
        //setContentView(R.layout.activity_custom_view_example)

        //For Bitmap
        //val d = CustomViewDemoTwo(this)
        //setContentView(d)

        //For Spinning Arc or moving Rectangle
        val d = CustomViewDemoThreeArc(this)
        setContentView(d)
    }
}