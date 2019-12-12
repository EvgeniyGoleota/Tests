package com.example.tests.ui.main

import com.example.tests.R

class MainPresenter(private val mView: MainContract.View) : MainContract.Presenter {
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

    override fun clickButton() {

    }

}
