package com.example.mvvmsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mvvmsample.databinding.RecyclerRowBinding

class MainAdapter(private var dataList: ArrayList<DataViewModel>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) = holder.bind(dataList[position])

    fun setItem(dataList: ArrayList<DataViewModel>) {
        if (dataList.isEmpty())
            return

        this.dataList = dataList
        notifyDataSetChanged()
    }

    inner class MainViewHolder(private val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mainData: DataViewModel) {
            binding.setVariable(BR.mainData, mainData)
        }
    }
}