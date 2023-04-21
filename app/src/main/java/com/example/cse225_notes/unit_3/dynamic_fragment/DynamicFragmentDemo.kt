package com.example.cse225_notes.unit_3.dynamic_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.cse225_notes.R

class DynamicFragmentDemo : AppCompatActivity() {

    val fm: FragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragment_demo)
    }

    fun onClickFirst(v: View) {

        val ft = fm.beginTransaction()
        ft.add(R.id.frameLayout, DynamicFragmentDemoOne())
        ft.addToBackStack(null)
        ft.commit()
    }

    fun onClickSecond(v: View) {

        val ft = fm.beginTransaction()
        ft.add(R.id.frameLayout, DynamicFragmentDemoTwo())
        ft.addToBackStack(null)
        ft.commit()
    }

    fun onClickThird(v: View) {

        var i = fm.backStackEntryCount
        while (i > 0) {
            fm.popBackStack()
            i--
        }
    }
}