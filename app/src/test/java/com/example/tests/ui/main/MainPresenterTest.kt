package com.example.tests.ui.main

import com.example.tests.R
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainPresenterTest {

    @Mock
    lateinit var view: MainContract.View

    lateinit var presenter: MainContract.Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(view)
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

    @Test
    fun clickButton() {
    }
}