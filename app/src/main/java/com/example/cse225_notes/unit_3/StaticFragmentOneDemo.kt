package com.example.cse225_notes.unit_3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.cse225_notes.R

class  StaticFragmentOneDemo : Fragment() {

    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_static_fragment_one_demo, container, false)
        init(container)
        return v
    }

    lateinit var buttonListener: BackPressCall
    override fun onAttach(context: Context) {
        super.onAttach(context)
        buttonListener = try {
            activity as BackPressCall
        } catch (e: java.lang.ClassCastException) {
            throw ClassCastException("$context must implement onButtonPressed")
        }
    }

    fun init(root: ViewGroup?) {
        val b1: Button = v.findViewById(R.id.send)
        val b2: Button = v.findViewById(R.id.clear)

        Toast.makeText(context, "init", Toast.LENGTH_LONG).show()

        b1.setOnClickListener {
            buttonListener.onBackPressCall("Send button has been clicked")
        }
        b2.setOnClickListener {
            buttonListener.onBackPressCall("")
        }
    }
}