package com.example.pizza.product.vm

import androidx.lifecycle.LiveData
import com.example.pizza.product.model.ProductDetailsModel

interface ProductDetailsViewModel {
    val productDetailsModel: LiveData<ProductDetailsModel>
    val images :LiveData<List<String>>
    val backToGeneralScreen : LiveData<Unit>
    fun onViewCreated()
    fun onClickedBackToGeneral()
}