package com.example.pizza.mycart.interactor

import com.example.pizza.mycart.model.MyCartModel

interface MyCartInteractor {
    suspend fun getMyCart(): MyCartModel
}