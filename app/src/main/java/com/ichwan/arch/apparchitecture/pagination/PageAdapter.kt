package com.ichwan.arch.apparchitecture.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ichwan.arch.apparchitecture.databinding.PageItemBinding

class PageAdapter(private var data: ArrayList<PageModels>) : RecyclerView.Adapter<PageAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: PageItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(data[position]){
                binding.apply {
                    textList.text = name
                }
            }
        }
    }
}