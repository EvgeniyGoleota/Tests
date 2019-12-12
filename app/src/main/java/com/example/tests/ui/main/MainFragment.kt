package com.example.tests.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tests.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.*
import java.lang.NumberFormatException

class MainFragment : Fragment(), MainContract.View {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var mPresenter: MainContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message.addTextChangedListener(object : TextWatcher {

            val handler = Handler(Looper.getMainLooper())

            override fun afterTextChanged(s: Editable?) {
                handler.postDelayed({
                    try {
                        val number = s.toString().toDouble()
                        mPresenter.validateNumber(number)
                    } catch (e: NumberFormatException) {
                        showSnackBar(R.string.use_number)
                    }
                }, 500)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                handler.removeCallbacksAndMessages(null)
            }

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter = MainPresenter(this)
    }

    override fun showSnackBar(messageId: Int) {
        context?.let { context ->
            view?.let { view ->
                Snackbar.make(view, context.getString(messageId), Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun disableButton() {
        button.isEnabled = false
    }

    override fun enableButton() {
        button.isEnabled = true
    }
}
