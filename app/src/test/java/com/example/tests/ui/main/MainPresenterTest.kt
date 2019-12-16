package com.example.tests.ui.main

import android.content.Context
import android.os.Build
import com.example.tests.R
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class MainPresenterTest {

    private val view: MainContract.View = mock()
    private val context: Context = mock()
    private val spanUtils: SpanUtils = mock()

    private lateinit var presenter: MainContract.Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(view, spanUtils)
    }

    @Test
    fun validateNumberSuccess() {
        presenter.validateNumber(101.0)
        verify(view).enableButton()
    }

    @Test
    fun validateNumberGreaterFailed() {
        presenter.validateNumber(1010.0)
        verify(view).disableButton()
        verify(view).showSnackBar(R.string.number_greater_error)
    }

    @Test
    fun validateNumberLessFailed() {
        presenter.validateNumber(11.0)
        verify(view).disableButton()
        verify(view).showSnackBar(R.string.number_less_error)
    }

    private fun <T> any(): T = Mockito.any<T>()

    @Test
    fun clickButton() {
        val text = "111"
        presenter.clickButton(text)

//        argumentCaptor<String>().apply {
//            verify(spanUtils).modifyFirstLetter()
//            Assert.assertEquals(text, firstValue)
//        }

        verify(spanUtils).modifyFirstLetter()
        verify(view).setResult(any())
    }
}