package com.example.mvvmsample

import android.databinding.ObservableArrayList
import java.util.*

class MainViewModel {
    val list = ObservableArrayList<DataViewModel>()

    fun newUser(){
        list.add(DataViewModel("name : " + random(), "content : " + random()))
    }

    private fun random(): Int {
        return Random().nextInt(1000)
    }
}