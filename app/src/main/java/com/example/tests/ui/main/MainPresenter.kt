package com.example.tests.ui.main

import android.content.Context
import com.example.tests.R

class MainPresenter(private val mView: MainContract.View, private val context: Context, private val spanUtils: SpanUtils) : MainContract.Presenter {
    override fun validateNumber(number: Double) {
        when {
            number > 1000 -> {
                mView.disableButton()
                mView.showSnackBar(R.string.number_greater_error)
            }
            number < 100 -> {
                mView.disableButton()
                mView.showSnackBar(R.string.number_less_error)
            }
            else -> {
                mView.enableButton()
            }
        }
    }

    override fun clickButton(text: String) {
        val result = spanUtils.modifyFirstLetter(text, context)
        mView.setResult(result)
    }
}
