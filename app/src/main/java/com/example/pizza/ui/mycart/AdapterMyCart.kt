package com.example.pizza.ui.mycart

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.DataMyCart
import com.example.pizza.databinding.FragmentMyCartBinding
import com.example.pizza.databinding.ItemBestSellerBinding

class AdapterMyCart :
    RecyclerView.Adapter<AdapterMyCart.ViewHolder>() {
    private var dataSetSeller = ArrayList<DataMyCart>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataMyCart(newList: List<DataMyCart>) {
        dataSetSeller.clear()
        dataSetSeller.addAll(newList)
        Log.d("1", "setData")
        notifyDataSetChanged()
    }

    //TODO переименовать
    class ViewHolder(private val binding: FragmentMyCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataMyCart) {
            binding.textView2.text = data.delivery
           // binding.description.text = data.price_without_discount.toString()
           // binding.price.text = data.price_without.toString()
          //  Glide.with(binding.root.context).load(data.picture).into(binding.imageSeller)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentMyCartBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSetSeller[position])

    }

    override fun getItemCount() = dataSetSeller.size
}
