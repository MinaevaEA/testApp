package com.example.pizza.general.model

data class BestSellerModel(
    val id: Int,
    val is_favorite: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)
