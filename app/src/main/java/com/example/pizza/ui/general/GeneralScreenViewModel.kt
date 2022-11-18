package com.example.pizza.ui.general

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pizza.*
import kotlinx.coroutines.launch

data class NewDataCategory(var isChecked: Boolean, val category: String)

class GeneralScreenViewModel(private val dataFromDataBase: DataNetworkInteract) :
    ViewModel() {
    //TODO названия set
    val loadingListBestSeller = MutableLiveData<List<BestSeller>>()
    val loadingListCategory = MutableLiveData<List<DataCategory>>()
    val loadingHomeStore = MutableLiveData<List<HomeStore>>()
    val openProductDetails = SingleLiveEvent<String>()
    val openFilter = SingleLiveEvent<Unit>()
    val categoryCheckedEvent = MutableLiveData<List<NewDataCategory>>()
    private var listCategory = mutableListOf<NewDataCategory>()

    fun onViewCreatedLoadingList() {

        viewModelScope.launch {
            //TODO названия
            val listPizzaResponse = dataFromDataBase.dataNetworkListInteract().best_seller
            loadingListBestSeller.postValue(listPizzaResponse)
            val listHomeStore = dataFromDataBase.dataNetworkListInteract().homeStore
            loadingHomeStore.postValue(listHomeStore)
            val listCategoryResponse = dataFromDataBase.dataCategory
            loadingListCategory.postValue(listCategoryResponse)
            openFilter.postValue(Unit)

            for (n in listCategoryResponse.indices) {
                val isChecked = n == 0
                val newCategory = NewDataCategory(isChecked, listCategoryResponse[n].category)
                listCategory.add(newCategory)
            }
            categoryCheckedEvent.postValue(listCategory)
        }
    }

    fun onClickedDetail(currencyPosition: String) {
        openProductDetails.postValue(currencyPosition)
    }

    fun onCategoryClicked(position: Int) {
        listCategory.forEachIndexed { index, newDataCategory ->
            newDataCategory.isChecked = index == position
        }
        categoryCheckedEvent.postValue(listCategory)
    }
}


@Suppress("UNCHECKED_CAST")
class GeneralScreenViewModelFactory(
    private val interact: DataNetworkInteract
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        GeneralScreenViewModel(interact) as T
}