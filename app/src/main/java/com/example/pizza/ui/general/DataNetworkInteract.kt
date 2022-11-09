package com.example.pizza.ui.general

import com.example.pizza.DataCategory
import com.example.pizza.DataList
import com.example.pizza.retrofit.RetrofitServices

class DataNetworkInteract(
    private val dataNetworkInteract: RetrofitServices,
    val dataCategory: List<DataCategory>
) {
    suspend fun dataNetworkListInteract(): DataList {
        return dataNetworkInteract.getAll()
    }
}





