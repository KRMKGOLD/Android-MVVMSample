package com.example.mvvmsample

import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.RatingBar
import android.widget.Toast


class MainViewModel {
    val name = ObservableField<String>("")
    val email = ObservableField<String>("")
    var score = ObservableInt()
    val isValid = ObservableBoolean()

    fun onCreate() {
        score.set(0)
        isValid.set(false)

        name.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(observable: Observable, i: Int) {
                validation()
            }
        })

        email.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(observable: Observable, i: Int) {
                validation()
            }
        })
    }

    var scoreChangeListener: RatingBar.OnRatingBarChangeListener =
        RatingBar.OnRatingBarChangeListener { ratingBar, v, b ->
            score.set(v.toInt())
            validation()
        }

    fun showToast(view : View){
        Toast.makeText(view.context, email.get(), Toast.LENGTH_SHORT).show()
    }

    fun validation() {
        val isValidName = !TextUtils.isEmpty(name.get())
        val isValidEmail = !TextUtils.isEmpty(email.get()) && Patterns.EMAIL_ADDRESS.matcher(email.get()).matches()
        val isValidScore = score.get() != 0
        isValid.set(isValidName && isValidEmail && isValidScore)
        isValid.set(isValidName && isValidEmail && isValidScore)
    }
}