package com.example.mvvmsample

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import com.example.mvvmsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list = ObservableArrayList<DataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.vm = MainViewModel()
        binding.recycler.adapter = MainAdapter(list)

        list.add(DataViewModel("a", "aaa"))
        list.add(DataViewModel("b", "bbb"))
        list.add(DataViewModel("c", "ccc"))
        list.add(DataViewModel("d", "ddd"))
        list.add(DataViewModel("e", "eee"))
    }

    companion object {
        @JvmStatic
        @BindingAdapter("item")
        fun bindItem(recyclerView: RecyclerView?, listData: ObservableArrayList<DataViewModel>?) {
            val adapter = recyclerView?.adapter as MainAdapter?
            if (adapter != null) {
                listData?.let { adapter.setItem(it) }
            }
        }

        @JvmStatic
        @BindingAdapter("app:decorator")
        fun setDecorator(recyclerView: RecyclerView?, decorator: ObservableField<DividerItemDecoration>?) {
            decorator?.get()?.let { recyclerView?.addItemDecoration(it) }
        }
    }
}
