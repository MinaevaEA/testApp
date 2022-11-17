package com.example.pizza.ui.general

import com.example.pizza.DataCategory
import com.example.pizza.retrofit.RetrofitServices
import dagger.Module
import dagger.Provides

@Module
class GeneralScreenModule {

    @Provides
    fun getGeneralScreenInteract(
        dataNetworkInteract: RetrofitServices,
        dataCategory: List<DataCategory>
    ): DataNetworkInteract {
        return DataNetworkInteract(dataNetworkInteract, dataCategory)
    }

 }