package com.example.cse225_notes.unit_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cse225_notes.R

class ColorActivityDemo : AppCompatActivity(), ColorInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_demo)
    }

    override fun newColor(color: Int) {
        val f = supportFragmentManager.findFragmentByTag("fragment2") as ColorFragmentDemo2
        f.updateColor(color)
    }
}