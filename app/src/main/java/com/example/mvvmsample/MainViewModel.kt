package com.example.mvvmsample

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class MainViewModel : ViewModel(){
    val editTextData = ObservableField<String>("")
}