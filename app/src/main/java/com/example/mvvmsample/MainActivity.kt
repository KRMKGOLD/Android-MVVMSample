package com.example.mvvmsample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mvvmsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: MainViewPagerAdapter
    private lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        adapter = MainViewPagerAdapter(supportFragmentManager)
        vm = MainViewModel()

        binding.vm = vm
        binding.viewPager.adapter = adapter
        vm.maxPage.set(adapter.count)
        vm.onCreate()
    }
}
