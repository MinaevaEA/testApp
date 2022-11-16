package com.example.pizza.ui.general

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pizza.*
import kotlinx.coroutines.launch


class GeneralScreenViewModel(private val dataFromDataBase: DataNetworkInteract) :
    ViewModel() {
    val loadingListBestSeller = MutableLiveData<List<BestSeller>>()
    val loadingListCategory = MutableLiveData<List<DataCategory>>()

    val loadingHomeStore = MutableLiveData<List<HomeStore>>()
    val openProductDetails = SingleLiveEvent<String>()
    val openFilter = SingleLiveEvent<Unit>()
    fun onViewCreatedLoadingList() {
        viewModelScope.launch {
            val listPizzaResponse = dataFromDataBase.dataNetworkListInteract().best_seller
            loadingListBestSeller.postValue(listPizzaResponse)
            val listHomeStore = dataFromDataBase.dataNetworkListInteract().home_store
            loadingHomeStore.postValue(listHomeStore)
            val listCategoryResponse = dataFromDataBase.dataCategory
            loadingListCategory.postValue(listCategoryResponse)
            openFilter.postValue(Unit)
        }
    }

    fun onClickedDetail(currencyPosition: String) {
        openProductDetails.postValue(currencyPosition)
    }
}

@Suppress("UNCHECKED_CAST")
class GeneralScreenViewModelFactory(
    private val interact: DataNetworkInteract
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        GeneralScreenViewModel(interact) as T
}