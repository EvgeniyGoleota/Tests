package com.example.tests.ui.main

import android.content.Context
import android.os.Build
import com.example.tests.R
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class MainPresenterTest {

    @Mock
    lateinit var view: MainContract.View

    @Mock
    private lateinit var context: Context

    private lateinit var presenter: MainContract.Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(view, context)
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
        presenter.clickButton("111")
        verify(view).setResult(any())
    }
}