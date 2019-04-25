package com.example.mvvmsample

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class MainViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        return when(position){
            0 -> AFragment()
            1 -> BFragment()
            2 -> CFragment()
            else -> null
        }
    }

    override fun getCount(): Int = 3
}