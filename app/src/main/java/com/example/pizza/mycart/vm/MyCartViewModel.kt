package com.example.pizza.mycart.vm

import androidx.lifecycle.LiveData
import com.example.pizza.mycart.model.BasketModel
import com.example.pizza.mycart.model.MyCartModel

interface MyCartViewModel {
    val myCartModel: LiveData<MyCartModel>
    val listBasketItem: LiveData<List<BasketModel>>
    val backToGeneralScreen: LiveData<Unit>
    fun onViewCreated()
    fun onClickedBackToGeneral()
    
}