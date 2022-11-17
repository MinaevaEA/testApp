package com.example.pizza.ui.product


import com.example.pizza.DataProductDetails
import com.example.pizza.retrofit.RetrofitServices

class DataNetworkDetailsInteract(
    private val dataNetworkDetailsInteract: RetrofitServices
) {
    suspend fun dataNetworkListInteract(): DataProductDetails {
        return dataNetworkDetailsInteract.getProductDetails()
    }

}
