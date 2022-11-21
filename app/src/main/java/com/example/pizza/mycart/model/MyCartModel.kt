package com.example.pizza.mycart.model


data class MyCartModel(
    val basket: List<BasketModel>,
    val delivery: String,
    val id: String,
    val total: String
)
