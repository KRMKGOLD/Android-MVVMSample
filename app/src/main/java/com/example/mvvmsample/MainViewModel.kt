package com.example.mvvmsample

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableInt
import android.view.View

class MainViewModel : ViewModel() {
    val currentPage = ObservableInt(0)
    val maxPage = ObservableInt()
    val isFirstPage = ObservableBoolean()
    val isLastPage = ObservableBoolean()

    fun onCreate() {
        currentPage.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                pageMoved()
            }
        })
        isFirstPage.set(true)
    }

    private fun pageMoved() {
        isFirstPage.set(currentPage.get() == 0)
        isLastPage.set(currentPage.get() == maxPage.get() - 1)
    }

    val pageChangeButtonListener =
        View.OnClickListener { view -> currentPage.set(currentPage.get() + Integer.valueOf(view?.tag.toString())) }
}