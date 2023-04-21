package com.example.cse225_notes.unit_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.cse225_notes.R
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException

class ReadExternalStorageDemo : AppCompatActivity() {

    lateinit var readData: TextView
    lateinit var read: Button
    lateinit var write: Button

    lateinit var fstream: FileInputStream
    private val fileName = "SampleFile.txt"
    private val filePath = "MyFileStorage"
    lateinit var myExternalFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_external_storage_demo)
        readData = findViewById(R.id.readData)
        read = findViewById(R.id.read)
        write = findViewById(R.id.write)

        read.setOnClickListener {
            try {
                myExternalFile = File(getExternalFilesDir(filePath), fileName)
                fstream = FileInputStream(myExternalFile)
                val sbuffer = StringBuffer()
                var i: Int
                while (fstream.read().also { i = it } != -1) {
                    sbuffer.append(i.toChar())
                }
                fstream.close()
                val details = sbuffer.toString()
                readData.text = """
                Details: ${details}
            """.trimIndent()

            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
        write.setOnClickListener {
            val intent = Intent(this, WriteExternalStorageDemo::class.java)
            startActivity(intent)
        }
    }
}