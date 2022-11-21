package com.example.pizza.general.model


import com.google.gson.annotations.SerializedName

data class StoreAndSellerListModel(
    @SerializedName("home_store")
    val homeStore: List<HomeStoreModel>,
    val best_seller: List<BestSellerModel>
)
