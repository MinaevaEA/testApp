package com.example.pizza.general.ui.bestselleradapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizza.databinding.ItemBestSellerBinding
import com.example.pizza.general.model.BestSellerModel

class BestSellerAdapter(private val bestSellerAdapterListener: BestSellerListener) :
    RecyclerView.Adapter<BestSellerAdapter.ViewHolder>() {
    private var dataSetSeller = ArrayList<BestSellerModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataBestSeller(newList: List<BestSellerModel>) {
        dataSetSeller.clear()
        dataSetSeller.addAll(newList)
        Log.d("1", "setData")
        notifyDataSetChanged()
    }

    //TODO переименовать
    class ViewHolder(private val binding: ItemBestSellerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BestSellerModel) {
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
            bestSellerAdapterListener.onDetailClicked(dataSetSeller[position].picture)
        }
    }

    override fun getItemCount() = dataSetSeller.size
}


