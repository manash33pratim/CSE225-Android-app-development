package com.example.cse225_notes.unit_5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.cse225_notes.R

class SharedPreferencesDemo : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var saveBtn: Button

    lateinit var sharedPreferences: SharedPreferences
    val Name = "nameKey"
    val Email = "emailKey"
    val File = "myPref"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_demo)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        saveBtn = findViewById(R.id.save)

        sharedPreferences = getSharedPreferences(File, Context.MODE_PRIVATE)

        name.setText(sharedPreferences.getString(Name, ""))
        email.setText(sharedPreferences.getString(Email, ""))
    }

    fun save(v: View) {

        val n = name.text.toString()
        val e = email.text.toString()
        val edit = sharedPreferences.edit()
        edit.putString(Name, n)
        edit.putString(Email, e)
        edit.apply()
    }

    fun clear(v: View) {

        name.setText("")
        email.setText("")
    }

    fun fetch(v: View) {

        sharedPreferences = getSharedPreferences(File, Context.MODE_PRIVATE)
        name.setText(sharedPreferences.getString(Name, ""))
        email.setText(sharedPreferences.getString(Email, ""))
    }
}