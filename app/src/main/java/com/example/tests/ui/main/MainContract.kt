package com.example.tests.ui.main

import android.text.SpannableString

interface MainContract {

    interface View {
        fun showSnackBar(messageId: Int)
        fun disableButton()
        fun enableButton()
        fun setResult(string: SpannableString)
    }

    interface Presenter {
        fun validateNumber(number: Double)
        fun clickButton(text: String)
    }
}