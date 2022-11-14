package com.example.pizza.ui.mycart

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizza.DataBasket
import com.example.pizza.databinding.ItemMyCartBinding

class MyCartAdapter :
    RecyclerView.Adapter<MyCartAdapter.ViewHolder>() {
    private var dataSetSeller = ArrayList<DataBasket>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataMyCart(newList: List<DataBasket>) {
        dataSetSeller.clear()
        dataSetSeller.addAll(newList)
        Log.d("1", "setData")
        notifyDataSetChanged()
    }

    //TODO переименовать
    class ViewHolder(private val binding: ItemMyCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataBasket) {
           binding.title.text=data.title
            binding.price.text = data.price.toString()
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
