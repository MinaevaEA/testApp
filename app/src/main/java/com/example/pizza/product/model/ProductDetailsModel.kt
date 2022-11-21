package com.example.pizza.product.model


data class ProductDetailsModel(
    val CPU: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val id: Int,
    val is_Favorite: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String,
    val images: List<String>
)
