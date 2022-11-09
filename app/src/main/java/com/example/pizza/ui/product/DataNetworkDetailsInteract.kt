package com.example.pizza.ui.product

import android.util.Log
import com.example.pizza.DataProductDetails
import com.example.pizza.retrofit.RetrofitServices
import java.lang.Exception

class DataNetworkDetailsInteract(private val dataNetworkDetailsInteract: RetrofitServices
    ) {

        suspend fun dataNetworkListInteract(): DataProductDetails? {
            //TODO корутина эксепшн
            try {
                Log.d("3333", "yes")
                return dataNetworkDetailsInteract.getProductDetails()
                Log.d("4444", "yes")
            } catch (e: Exception) {
                Log.d("3333", "$e")
                Log.d("333", "${e.getLocalizedMessage()}")
                Log.d("333", "${e.cause}")
                return null
            }

        }

    }
