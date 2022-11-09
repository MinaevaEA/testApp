package com.example.pizza.ui.general

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizza.HomeStore
import com.example.pizza.databinding.ItemHomeStoreBinding

class ViewPagerAdapterHomeStore :
    RecyclerView.Adapter<ViewPagerAdapterHomeStore.ViewPagerViewHolder>() {
    private var dataSetStore = ArrayList<HomeStore>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataHomeStore(newList: List<HomeStore>) {
        dataSetStore.clear()
        dataSetStore.addAll(newList)
        Log.d("1", "setData")
        notifyDataSetChanged()
    }

    class ViewPagerViewHolder(private val binding: ItemHomeStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HomeStore) {
            binding.title.text = data.title
            binding.subtitle.text = data.subtitle
            Glide.with(binding.root.context).load(data.picture).into(binding.imageStore);
        }
    }

    override fun getItemCount(): Int = dataSetStore.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {

        val binding = ItemHomeStoreBinding.inflate(
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






