package com.example.pizza.general.ui.categoryadapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.databinding.ItemCategoryBinding
import com.example.pizza.general.model.NewCategoryModel


class CategoryAdapter(private val categoryAdapterListener: CategoryAdapterListener) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    private val newDataSetCategory = ArrayList<NewCategoryModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setNewDataCategory(newListD: List<NewCategoryModel>) {
        newDataSetCategory.clear()
        newDataSetCategory.addAll(newListD)
        Log.d("category", "setData: $newListD")
        notifyDataSetChanged()
    }

    class MyViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: NewCategoryModel) {
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


