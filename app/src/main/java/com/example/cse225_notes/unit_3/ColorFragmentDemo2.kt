package com.example.cse225_notes.unit_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.cse225_notes.R

class ColorFragmentDemo2 : Fragment() {

    lateinit var parent: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_color_demo_2, container, false)
        parent = v.findViewById(R.id.frag2parent)
        return v
    }

    fun updateColor(c: Int) {
        parent.setBackgroundColor(c)
    }
}