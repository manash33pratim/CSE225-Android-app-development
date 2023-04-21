package com.example.cse225_notes.unit_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cse225_notes.R

class FragmentDemo : AppCompatActivity(), BackPressCall {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_demo)
    }

    override fun onBackPressCall(msg: String) {
        var o = supportFragmentManager.findFragmentById(R.id.fragment2) as StaticFragmentTwoDemo
        o.onFragmentInteraction(msg)
    }
}