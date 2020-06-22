package com.dehaat.dehaatassignment.util

import android.content.Context
import android.widget.TextView
import com.dehaat.dehaatassignment.R

object UiUtils {

    fun isTextTooLarge(context: Context, textView: TextView, newText: String?, maxLine: Int): Boolean {
        val textWidth = textView.paint.measureText(newText)
        var wPixel = textView.measuredWidth
        wPixel -= 2 * context.resources.getDimensionPixelOffset(R.dimen.item_card_padding)
        return textWidth >= maxLine * wPixel

    }
}