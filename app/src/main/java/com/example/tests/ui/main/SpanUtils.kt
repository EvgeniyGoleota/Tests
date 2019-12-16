package com.example.tests.ui.main

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.core.content.ContextCompat
import com.example.tests.R

class SpanUtils(private val context: Context) {

    private fun getText() = context.getString(R.string.test_string)

    fun modifyFirstLetter() = SpannableString(getText()).apply {
        setSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.red)), 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        setSpan(StyleSpan(Typeface.BOLD), 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
    }
}