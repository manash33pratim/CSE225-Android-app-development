package com.example.cse225_notes.unit_3

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.cse225_notes.R

class ColorFragmentDemo1 : Fragment() {

    lateinit var buttonBlue: Button
    lateinit var buttonGreen: Button
    lateinit var clearButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_color_demo_1, container, false)

        buttonBlue = v.findViewById(R.id.buttonBlue)
        buttonBlue.setOnClickListener {
            val mai = activity as ColorActivityDemo
            mai.newColor(Color.BLUE)
        }

        buttonGreen = v.findViewById(R.id.buttonGreen)
        buttonGreen.setOnClickListener {
            val mai = activity as ColorActivityDemo
            mai.newColor(Color.GREEN)
        }

        clearButton = v.findViewById(R.id.clearColor)
        clearButton.setOnClickListener {
            val mai = activity as ColorActivityDemo
            mai.newColor(Color.WHITE)
        }

        return v
    }
}