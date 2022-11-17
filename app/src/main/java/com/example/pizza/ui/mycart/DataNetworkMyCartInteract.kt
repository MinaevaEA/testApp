package com.example.pizza.ui.mycart

import com.example.pizza.DataMyCart
import com.example.pizza.retrofit.RetrofitServices

class DataNetworkMyCartInteract(
    private val dataNetworkInteract: RetrofitServices) {
    suspend fun dataMyCartInteract(): DataMyCart {
            return dataNetworkInteract.getMyCart()
    }
}





