package com.example.pizza.mycart.ui.adapterlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizza.databinding.ItemMyCartBinding
import com.example.pizza.mycart.model.BasketModel

class MyCartAdapter :
    RecyclerView.Adapter<MyCartAdapter.ViewHolder>() {
    private var dataSetSeller = ArrayList<BasketModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataMyCart(newList: List<BasketModel>) {
        dataSetSeller.clear()
        dataSetSeller.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemMyCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BasketModel) {
            binding.title.text = data.title
            binding.priceCart.text = data.price.toString()
            Glide.with(binding.root.context).load(data.images).into(binding.imageSeller)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMyCartBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSetSeller[position])
    }

    override fun getItemCount() = dataSetSeller.size
}
