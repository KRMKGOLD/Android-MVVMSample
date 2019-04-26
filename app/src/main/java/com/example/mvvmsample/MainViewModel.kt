package com.example.mvvmsample

class MainViewModel(private val navigator : CallAnotherActivityInterface) {
    fun callActivity() {
        navigator.callActivity()
    }
}