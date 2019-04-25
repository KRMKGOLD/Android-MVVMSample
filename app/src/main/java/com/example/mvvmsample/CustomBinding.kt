package com.example.mvvmsample

import android.databinding.BindingAdapter
import android.support.v4.view.ViewPager

class CustomBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("currentItem")
        fun setCurrentItem(viewpager : ViewPager, currentPage : Int){
            viewpager.currentItem = currentPage
        }
    }
}