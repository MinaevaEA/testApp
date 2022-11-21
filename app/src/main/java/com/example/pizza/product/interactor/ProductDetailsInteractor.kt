package com.example.pizza.product.interactor

import com.example.pizza.product.model.ProductDetailsModel

interface ProductDetailsInteractor {
    suspend fun getProductDetails(): ProductDetailsModel
}