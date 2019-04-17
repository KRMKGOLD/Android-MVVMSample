package com.example.mvvmsample

import android.databinding.ObservableField

class MainViewModel {
    val text = ObservableField<String>("Basic Text!")

    fun changeText() {
        if(text.get() == "Basic Text!")
            text.set("Click!")
        else if(text.get() == "Click!")
            text.set("Basic Text!")
    }
}