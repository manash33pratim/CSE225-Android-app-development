package com.example.cse225_notes.unit_4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class CustomViewDemoThreeArc(context: Context) : View(context) {

    private var p = Paint()

    //For Fan
    //var x = 100f

    //For Rectangle
    var a = 100f
    var b = 300f

    override fun onDraw(canvas: Canvas?) {

        //For Fan
        p.color = Color.BLACK
        /*canvas?.drawArc(500f, 500f, 800f, 800f, x.toFloat(), 30f, true, p)
        canvas?.drawArc(500f, 500f, 800f, 800f, (x + 120).toFloat(), 30f, true, p)
        canvas?.drawArc(500f, 500f, 800f, 800f, (x + 240).toFloat(), 30f, true, p)*/

        //For moving rectangle
        canvas?.drawRect(a, 100f, b, 200f, p)
        super.onDraw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> startFan()
            MotionEvent.ACTION_UP -> stopFan()
        }
        return true
    }

    fun startFan() {

        //For Fan
        //x += 100

        //For Ractangle
        a += 20
        b += 20
        invalidate()
    }

    fun stopFan() {
    }
}