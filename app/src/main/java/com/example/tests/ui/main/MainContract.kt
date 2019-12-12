package com.example.tests.ui.main

interface MainContract {

    interface View {
        fun showSnackBar(messageId: Int)
        fun disableButton()
        fun enableButton()
    }

    interface Presenter {
        fun validateNumber(number: Double)
        fun clickButton()
    }
}