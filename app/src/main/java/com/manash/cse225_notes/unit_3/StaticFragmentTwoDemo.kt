package com.manash.cse225_notes.unit_3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.manash.cse225_notes.R

class StaticFragmentTwoDemo : Fragment() {

    lateinit var v1: View
    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v1 = inflater.inflate(R.layout.fragment_static_fragment_two_demo, container, false)
        return v1
    }

    fun onFragmentInteraction(uri: String) {
        Log.d("K202", uri)
        textView = v1.findViewById(R.id.tv1)
        textView.setText(uri)
    }

}