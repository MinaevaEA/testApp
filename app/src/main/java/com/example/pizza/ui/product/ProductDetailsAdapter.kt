package com.example.pizza.ui.product

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizza.databinding.ItemPageProductDetailsBinding

class ProductDetailsAdapter :
    RecyclerView.Adapter<ProductDetailsAdapter.ViewPagerViewHolder>() {
    private var dataSetStore = ArrayList<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataProductDetails(newList: List<String>) {
        dataSetStore.clear()
        dataSetStore.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewPagerViewHolder(private val binding: ItemPageProductDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            Glide.with(binding.root.context).load(data).into(binding.imageModel)
        }
    }

    override fun getItemCount(): Int = dataSetStore.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {

        val binding = ItemPageProductDetailsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(dataSetStore[position])
    }
}






