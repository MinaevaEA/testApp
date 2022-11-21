package com.example.pizza.general.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pizza.*
import com.example.pizza.general.interactor.GeneralScreenInteractor
import com.example.pizza.general.model.BestSellerModel
import com.example.pizza.general.model.CategoryModel
import com.example.pizza.general.model.HomeStoreModel
import com.example.pizza.general.model.NewCategoryModel
import kotlinx.coroutines.launch


class GeneralScreenViewModelImpl(private val generalScreenInteractor: GeneralScreenInteractor) :
    ViewModel(), GeneralScreenViewModel {

    override val bestSellerModel = MutableLiveData<List<BestSellerModel>>()
    override val categoryModel = MutableLiveData<List<CategoryModel>>()
    override val homeStoreModel = MutableLiveData<List<HomeStoreModel>>()
    override val openProductDetails = SingleLiveEvent<String>()
    override val openFilter = SingleLiveEvent<Unit>()
    override val categoryCheckedEvent = MutableLiveData<List<NewCategoryModel>>()
    private var newListCategory = mutableListOf<NewCategoryModel>()

    override fun onViewCreated() {
        viewModelScope.launch {
            val listBestSellerResponse = generalScreenInteractor.getStoreAndSellerList().best_seller
            bestSellerModel.postValue(listBestSellerResponse)
            val listHomeStoreResponse = generalScreenInteractor.getStoreAndSellerList().homeStore
            homeStoreModel.postValue(listHomeStoreResponse)
            val listCategoryResponse = generalScreenInteractor.getCategoryList()
            categoryModel.postValue(listCategoryResponse)

            for (n in listCategoryResponse.indices) {
                val isChecked = n == 0
                val newCategory = NewCategoryModel(isChecked, listCategoryResponse[n].category)
                newListCategory.add(newCategory)
            }
            categoryCheckedEvent.postValue(newListCategory)
        }
    }

    fun onFilterClicked() {
        openFilter.postValue(Unit)
    }

    fun onDetailClicked(currencyPosition: String) {
        openProductDetails.postValue(currencyPosition)
    }

    fun onCategoryClicked(position: Int) {
        newListCategory.forEachIndexed { index, newDataCategory ->
            newDataCategory.isChecked = index == position
        }
        categoryCheckedEvent.postValue(newListCategory)
    }
}


@Suppress("UNCHECKED_CAST")
class GeneralScreenViewModelFactory(
    private val generalScreenInteractor: GeneralScreenInteractor
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        GeneralScreenViewModelImpl(generalScreenInteractor) as T
}