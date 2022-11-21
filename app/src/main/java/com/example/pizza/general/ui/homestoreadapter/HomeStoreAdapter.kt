package com.example.pizza.general.ui.homestoreadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.pizza.databinding.ItemHomeStoreBinding
import com.example.pizza.general.model.HomeStoreModel

class HomeStoreAdapter :
    RecyclerView.Adapter<HomeStoreAdapter.ViewPagerViewHolder>() {
    private var dataSetStore = ArrayList<HomeStoreModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setDataHomeStore(newList: List<HomeStoreModel>) {
        dataSetStore.clear()
        dataSetStore.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewPagerViewHolder(private val binding: ItemHomeStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HomeStoreModel) {
            binding.title.text = data.title
            binding.subtitle.text = data.subtitle
            Glide.with(binding.root.context).load(data.picture).into(binding.imageStore)
            if (data.is_new) {
                binding.isNew.visibility = View.VISIBLE
            } else {
                binding.isNew.visibility = View.INVISIBLE
            }
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






