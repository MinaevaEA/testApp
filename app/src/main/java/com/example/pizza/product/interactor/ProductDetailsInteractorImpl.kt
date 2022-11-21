package com.example.pizza.product.interactor


import com.example.pizza.retrofit.RetrofitServices
import com.example.pizza.product.model.ProductDetailsModel

class ProductDetailsInteractorImpl(
    private val api: RetrofitServices
) : ProductDetailsInteractor {
    override suspend fun getProductDetails(): ProductDetailsModel {
        return api.getProductDetailsModel()
    }

}
