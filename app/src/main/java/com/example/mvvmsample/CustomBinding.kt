package com.example.mvvmsample

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

class CustomBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("app:item")
        fun setUserList(recyclerView: RecyclerView, users: ArrayList<DataViewModel>) {
            val adapter: MainAdapter

            if (recyclerView.adapter == null) {
                adapter = MainAdapter(users)
                recyclerView.adapter = adapter
            } else {
                adapter = recyclerView.adapter as MainAdapter
            }

            adapter.setItem(users)
        }
    }
}