package com.example.pizza.general.interactor

import com.example.pizza.general.model.CategoryModel
import com.example.pizza.general.model.StoreAndSellerListModel

interface GeneralScreenInteractor {
    suspend fun getStoreAndSellerList(): StoreAndSellerListModel
    suspend fun getCategoryList():List<CategoryModel>
}