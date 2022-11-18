package com.example.pizza.ui.general

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.DataCategory
import com.example.pizza.databinding.ItemCategoryBinding


class CategoryAdapter(private val categoryAdapterListener: categoryAdapterListener) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    private val newDataSetCategory = ArrayList<NewDataCategory>()

    @SuppressLint("NotifyDataSetChanged")
    fun setNewDataCategory(newListD: List<NewDataCategory>) {
        newDataSetCategory.clear()
        newDataSetCategory.addAll(newListD)
        Log.d("category", "setData: $newListD")
        notifyDataSetChanged()
    }

    class MyViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: NewDataCategory) {
            binding.category.text = data.category
             binding.checkBox.isChecked = data.isChecked
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(newDataSetCategory[position])
        holder.itemView.rootView.setOnClickListener {
            categoryAdapterListener.onCategoryClinked(position)
            Log.d("88888","click2")
        }
    }

    override fun getItemCount() = newDataSetCategory.size

}


