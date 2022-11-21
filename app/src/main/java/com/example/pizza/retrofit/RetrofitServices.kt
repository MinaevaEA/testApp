package com.example.pizza.retrofit


import com.example.pizza.general.model.StoreAndSellerListModel
import com.example.pizza.mycart.model.MyCartModel
import com.example.pizza.product.model.ProductDetailsModel
import retrofit2.http.GET



interface RetrofitServices {
    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
   suspend fun getStoreAndSellerListModel(): StoreAndSellerListModel

    @GET("v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetailsModel(): ProductDetailsModel

    @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getMyCartModel(): MyCartModel

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
