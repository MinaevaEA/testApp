package com.example.pizza.ui.general

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizza.BestSeller
import com.example.pizza.R
import com.example.pizza.databinding.ItemBestSellerBinding

class AdapterBestSeller(private val currencyAdapterListener: ViewListener) :
    RecyclerView.Adapter<AdapterBestSeller.ViewHolder>() {
    private var dataSetSeller = ArrayList<BestSeller>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataBestSeller(newList: List<BestSeller>) {
        dataSetSeller.clear()
        dataSetSeller.addAll(newList)
        Log.d("1", "setData")
        notifyDataSetChanged()
    }

    //TODO переименовать
    class ViewHolder(private val binding: ItemBestSellerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BestSeller) {
            binding.title.text = data.title
            binding.price.text = data.discount_price.toString()
            binding.priceWithDiscnt.text = data.price_without_discount.toString()
            Glide.with(binding.root.context).load(data.picture).into(binding.imageSeller)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBestSellerBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSetSeller[position])
        holder.itemView.setOnClickListener {
            currencyAdapterListener.onClicked(dataSetSeller[position].picture)
        }
    }

    override fun getItemCount() = dataSetSeller.size
}


