package com.example.pizza.mycart.interactor


import com.example.pizza.retrofit.RetrofitServices
import com.example.pizza.mycart.model.MyCartModel

class MyCartInteractorImpl(
    private val api: RetrofitServices): MyCartInteractor {
    override suspend fun getMyCart(): MyCartModel {
            return api.getMyCartModel()
    }
}





