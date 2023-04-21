package com.example.cse225_notes.unit_4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomViewDemoOneSmiley(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var circleColor = Color.YELLOW
    var borderColor = Color.BLACK
    var borderSize = 10.0f
    private var eyeColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var mouthPath = Path()
    var circleRadius = 500f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawFace(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    fun drawFace(c: Canvas?) {
        paint.color = circleColor
        val radius = circleRadius / 2f
        c?.drawCircle(circleRadius / 2f, circleRadius / 2f, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderSize
        c?.drawCircle(circleRadius / 2f, circleRadius / 2f, radius - borderSize, paint)

    }

    fun drawEyes(c: Canvas?) {
        paint.color = eyeColor
        paint.style = Paint.Style.FILL
        val left = RectF(
            circleRadius * 0.29f,
            circleRadius * 0.23f,
            circleRadius * 0.4f,
            circleRadius * 0.50f
        )
        c?.drawOval(left, paint)
        val right = RectF(
            circleRadius * 0.71f,
            circleRadius * 0.23f,
            circleRadius * 0.6f,
            circleRadius * 0.50f
        )
        c?.drawOval(right, paint)
    }

    fun drawMouth(c: Canvas?) {
        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        mouthPath.moveTo(circleRadius * 0.22f, circleRadius * 0.7f)
        mouthPath.quadTo(
            circleRadius * 0.40f,
            circleRadius * 0.80f,
            circleRadius * 0.78f,
            circleRadius * 0.70f
        )
        mouthPath.quadTo(
            circleRadius * 0.40f,
            circleRadius * 0.90f,
            circleRadius * 0.22f,
            circleRadius * 0.70f
        )
        c?.drawPath(mouthPath, paint)
    }
}