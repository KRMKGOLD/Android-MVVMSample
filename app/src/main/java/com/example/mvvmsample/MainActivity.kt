package com.example.mvvmsample

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mvvmsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CallAnotherActivityInterface{
    private lateinit var binding : ActivityMainBinding
    private lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = MainViewModel(this)
        binding.vm = vm
    }

    override fun callActivity() {
        startActivity(Intent(this@MainActivity, SubActivity::class.java))
    }
}
