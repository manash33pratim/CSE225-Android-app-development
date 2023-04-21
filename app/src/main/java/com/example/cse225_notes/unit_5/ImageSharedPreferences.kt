package com.example.cse225_notes.unit_5

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.Button
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.example.cse225_notes.R
import java.io.ByteArrayOutputStream

class ImageSharedPreferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_shared_preferences)

        var iv1 = findViewById<ImageView>(R.id.iv1)
        var iv2 = findViewById<ImageView>(R.id.iv2)
        var save = findViewById<Button>(R.id.sendImage)
        var show = findViewById<Button>(R.id.receiveImage)
        var clear = findViewById<Button>(R.id.erase)

        save.setOnClickListener() {

            saveImage(iv1, this)
        }

        show.setOnClickListener() {

            loadLastImage(iv2, this)
        }

        clear.setOnClickListener() {

            eraseImage(iv2, this)
        }
    }

    fun saveImage(iv1: ImageView, context: Context) {

        val sharedPref = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val baos = ByteArrayOutputStream()
        val bitmap = iv1.drawable.toBitmap()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val encodedImage = Base64.encodeToString(
            baos.toByteArray(),
            Base64.DEFAULT
        )
        with(sharedPref.edit()) {
            putString("Encoded Image", encodedImage)
            apply()
        }
    }

    fun loadLastImage(iv2: ImageView, context: Context) {
        val sharedPref = context.getSharedPreferences(
            "sharedPref",
            Context.MODE_PRIVATE
        )
        val encodedImage = sharedPref.getString("Encoded Image", "DEFAULT")

        if (encodedImage != "DEFAULT") {
            val imageBytes = Base64.decode(encodedImage, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(
                imageBytes,
                0, imageBytes.size
            )
            iv2.setImageBitmap(decodedImage)
        }
    }

    fun eraseImage(iv2: ImageView, context: Context) {

        iv2.setImageBitmap(null)
    }
}