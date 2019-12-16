package com.example.tests.ui.main

import android.app.Application
import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.core.content.ContextCompat
import androidx.test.core.app.ApplicationProvider
import com.example.tests.R
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class SpanUtilsTest {

    private lateinit var context: Context
    private lateinit var spanUtils: SpanUtils

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext<Application>()
        spanUtils = SpanUtils()
    }

    @Test
    fun modifyFirstLetter() {
        val text  = "111"
        val actual = spanUtils.modifyFirstLetter(text, context)

        val colorSpans = actual.getSpans(0, actual.length, ForegroundColorSpan::class.java)
        assertEquals(1, colorSpans.size)
        assertEquals(ContextCompat.getColor(context, R.color.red), colorSpans[0].foregroundColor)

        val styleSpans = actual.getSpans(0, actual.length, StyleSpan::class.java)
        assertEquals(1, styleSpans.size)
        assertEquals(Typeface.BOLD, styleSpans[0].style)
    }
}