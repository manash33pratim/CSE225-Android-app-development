package com.example.cse225_notes.unit_4

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.cse225_notes.R


class CustomViewTextViewDemo : AppCompatTextView {
    private var title: String? = null
    private var color = false
    private var shading = false

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val tarry: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewCustom)
        try {
            title = tarry.getString(R.styleable.TextViewCustom_settitle)
            if (title == null)
                setText("Custom Message")
            else
                setText(title)

            color = tarry.getBoolean(R.styleable.TextViewCustom_setColor, false)
            if (color)
                setTextColor(Color.MAGENTA)
            shading = tarry.getBoolean(R.styleable.TextViewCustom_setshading, false)
            if (shading)
                setShadowLayer(1f, 1f, 1f, Color.BLACK)
        } finally {
            tarry.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }
}