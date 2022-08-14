package com.dmitry.kanbanapp.ui.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class StickerView @JvmOverloads
    constructor(private val ctx: Context,
                private val attributeSet: AttributeSet? = null,
                private val defStyleAttr: Int = 0
    ) : View(ctx, attributeSet, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#ffdd55")
        strokeWidth = 5f
    }

    private val sticker = Path().apply {
        moveTo(0f, 0f)
        lineTo(0f, 400f)
        lineTo(400f, 400f)
        lineTo(400f, 100f)
        lineTo(300f, 0f)
        close()
    }

    private val foldedCorner = Path().apply {
        moveTo(300f, 0f)
        lineTo(300f, 100f)
        lineTo(400f, 100f)
        close()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas);

        canvas?.drawPath(sticker, paint)
        canvas?.clipPath(sticker)
        paint.color = Color.parseColor("#d4aa00")
        canvas?.drawPath(foldedCorner, paint)
    }
}
