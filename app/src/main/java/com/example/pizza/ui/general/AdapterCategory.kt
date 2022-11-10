package com.example.pizza.ui.general

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.DataCategory
import com.example.pizza.databinding.ItemCategoryBinding

class AdapterCategory :
    RecyclerView.Adapter<AdapterCategory.MyViewHolder>() {
    private val dataSetCategory = ArrayList<DataCategory>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataCategory(newList: List<DataCategory>) {
        dataSetCategory.clear()
        dataSetCategory.addAll(newList)
        Log.d("1", "setData")
        notifyDataSetChanged()
    }

    //TODO сделать форму для кнопки через shape
    class MyViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataCategory) {
            binding.category.text = data.category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSetCategory[position])
    }

    override fun getItemCount() = dataSetCategory.size

}

