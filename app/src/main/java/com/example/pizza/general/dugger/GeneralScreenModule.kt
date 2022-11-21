package com.example.pizza.general.dugger

import com.example.pizza.general.model.CategoryModel
import com.example.pizza.general.interactor.GeneralScreenInteractorImpl
import com.example.pizza.retrofit.RetrofitServices
import dagger.Module
import dagger.Provides

@Module
class GeneralScreenModule {

    @Provides
    fun getGeneralScreenInteract(
        dataNetworkInteract: RetrofitServices,
        dataCategory: List<CategoryModel>
    ): GeneralScreenInteractorImpl {
        return GeneralScreenInteractorImpl(dataNetworkInteract, dataCategory)
    }

 }