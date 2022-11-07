package com.example.pizza.retrofit


import com.example.pizza.DataList
import com.example.pizza.DataPizza
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitServices {
    @GET("pizza.json?alt=media&token=986de358-715c-432b-9256-bf266f117360")
   suspend fun getAll(): DataList


    companion object {
        private const val baseUrl = "https://firebasestorage.googleapis.com/v0/b/pizzalist-dd5fb.appspot.com/o/"
        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}
