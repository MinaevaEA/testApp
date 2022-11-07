package com.example.pizza.ui.home

import android.util.Log
import com.example.pizza.DataCategory
import com.example.pizza.DataList
import com.example.pizza.DataPizza
import com.example.pizza.retrofit.RetrofitServices
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

/*class DataNetworkInteract(
    private val dataNetworkInteract: RetrofitServices,
    val dataCategory: List<DataCategory>
) {
    fun pizzaInteract(): List<DataPizza> {
        return dataNetworkInteract.getAll()
    }
}*/
class DataNetworkInteract(
    val dataNetworkInteract: RetrofitServices,
    val dataCategory: List<DataCategory>
) {

    suspend fun dataNetworkListInteract(): DataList? {
        //TODO корутина эксепшн
        try {
            Log.d("3333", "yes")
            Log.d("js", "${dataNetworkInteract.getAll()}")
            return dataNetworkInteract.getAll()


        } catch (e: Exception) {
            Log.d("3333", "$e")
            Log.d("333", "${e.getLocalizedMessage()}")
            Log.d("333", "${e.cause}")
            return null
        }

    }

}





