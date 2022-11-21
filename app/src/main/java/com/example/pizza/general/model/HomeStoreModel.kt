package com.example.pizza.general.model

data class HomeStoreModel(
    val id: Int,
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)
