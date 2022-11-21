package com.example.pizza.general.interactor

import com.example.pizza.general.model.CategoryModel
import com.example.pizza.general.model.StoreAndSellerListModel
import com.example.pizza.retrofit.RetrofitServices

class GeneralScreenInteractorImpl(
    private val api: RetrofitServices,
    private val listDataCategory: List<CategoryModel>
) : GeneralScreenInteractor{
    override suspend fun getStoreAndSellerList(): StoreAndSellerListModel {
        return api.getStoreAndSellerListModel()
    }

    override suspend fun getCategoryList(): List<CategoryModel> {
        return listDataCategory
    }

}





