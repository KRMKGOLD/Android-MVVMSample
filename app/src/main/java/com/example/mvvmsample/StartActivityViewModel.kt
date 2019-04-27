package com.example.mvvmsample

import android.view.View

class StartActivityViewModel(private val navigator : CallAnotherActivityInterface) {
    fun callActivity(view : View) {
        navigator.callActivity(view)
    }
}