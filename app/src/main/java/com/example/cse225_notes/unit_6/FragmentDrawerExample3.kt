package com.example.cse225_notes.unit_6
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cse225_notes.R


class FragmentDrawerExample3: Fragment() {
    lateinit var v:View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View?
    {
        v = inflater.inflate(R.layout.fragment_navigation_drawer_example3,container,false)
        return  v
    }
}