package com.example.pizza.ui.general

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.DataCategory
import com.example.pizza.databinding.ItemCategoryBinding


class CategoryAdapter(private val categoryAdapterListener: ViewListener) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    private val dataSetCategory = ArrayList<DataCategory>()
    private val newDataSetCategory = ArrayList<NewDataCategory>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataCategory(newList: List<DataCategory>) {
        dataSetCategory.clear()
        dataSetCategory.addAll(newList)
        Log.d("1", "setData")
        notifyDataSetChanged()
    }
    fun setNewDataCategory(newListD: List<NewDataCategory>) {
        newDataSetCategory.clear()
        newDataSetCategory.addAll(newListD)
        Log.d("1", "setData")
        notifyDataSetChanged()
    }

    class MyViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataCategory) {
            binding.category.text = data.category
            // binding.checkBox.isChecked = data.isChecked
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSetCategory[position])
     /*   holder.itemView.setOnClickListener {
            categoryAdapterListener.onCategoryClinked(dataSetCategory[position].)
        }*/
    }

    override fun getItemCount() = dataSetCategory.size

}


