package com.example.cse225_notes.unit_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cse225_notes.R
import java.io.IOException

class InternalStorageDemo : AppCompatActivity() {

    lateinit var send: Button
    lateinit var receive: Button
    lateinit var takeText: EditText
    lateinit var showText: TextView
    lateinit var data: String
    val fileName = "MyData.txt"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage_demo)

        send = findViewById(R.id.sendText)
        receive = findViewById(R.id.receiveText)
        takeText = findViewById(R.id.data)
        showText = findViewById(R.id.showData)

        send.setOnClickListener() {

            data = takeText.text.toString()
            try {
                val fout = openFileOutput(fileName, MODE_APPEND)
                fout.write(data.toByteArray())
                fout.close()
                Toast.makeText(this, "File appended", Toast.LENGTH_LONG).show()

            } catch (to: IOException) {

                to.printStackTrace()
            }
        }

        receive.setOnClickListener() {

            try {
                val fin = openFileInput(fileName)
                var c: Int
                var temp = ""
                while (fin.read().also { c = it } != -1) {
                    temp += c.toChar().toString()
                }
                showText.text = temp
                Toast.makeText(this, "Data Reflected", Toast.LENGTH_LONG).show()

            } catch (e: java.lang.Exception) {
            }
        }
    }
}