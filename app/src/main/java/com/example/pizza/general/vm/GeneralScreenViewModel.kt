package com.example.pizza.general.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pizza.SingleLiveEvent
import com.example.pizza.general.model.BestSellerModel
import com.example.pizza.general.model.CategoryModel
import com.example.pizza.general.model.HomeStoreModel
import com.example.pizza.general.model.NewCategoryModel

interface GeneralScreenViewModel {
    val bestSellerModel: LiveData<List<BestSellerModel>>
    val categoryModel :LiveData<List<CategoryModel>>
    val homeStoreModel : LiveData<List<HomeStoreModel>>
    val openProductDetails :LiveData<String>
    val openFilter : LiveData<Unit>
    val categoryCheckedEvent : LiveData<List<NewCategoryModel>>
    fun onViewCreated()
}