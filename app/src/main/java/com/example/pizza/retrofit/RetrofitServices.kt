package com.example.pizza.retrofit


import com.example.pizza.DataList
import com.example.pizza.DataMyCart
import com.example.pizza.DataProductDetails
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



interface RetrofitServices {
    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
   suspend fun getAll(): DataList

    @GET("v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetails(): DataProductDetails

    @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getMyCart(): DataMyCart

/*    companion object {
        private const val baseUrl = "https://run.mocky.io/"
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
    }*/
}
