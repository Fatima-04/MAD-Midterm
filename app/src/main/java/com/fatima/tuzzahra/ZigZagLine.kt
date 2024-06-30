package com.fatima.tuzzahra

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ZigZagLine @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){

    private val paint = Paint().apply {
        color = context.getColor(android.R.color.holo_blue_bright)
        strokeWidth = 5f
    }
    private lateinit var yCoordinates: FloatArray

    init {
        val yString = context.resources.getStringArray(R.array.y_coordinates)
        yCoordinates = yString.map { it.toFloat() }.toFloatArray()

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var startX = 0f
        var startY = yCoordinates[0]

        for(i in 1 until yCoordinates.size){
            val stopX = startX + 100
            val stopY = yCoordinates[i]
            canvas.drawLine(startX,startY,stopX, stopY, paint)
            startX = stopX
            startY = stopY


        }
    }
}