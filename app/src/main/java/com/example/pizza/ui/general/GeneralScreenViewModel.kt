package com.example.pizza.ui.general

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pizza.BestSeller
import com.example.pizza.DataCategory
import com.example.pizza.HomeStore
import com.example.pizza.SingleLiveEvent
import kotlinx.coroutines.launch


class GeneralScreenViewModel(private val dataFromDataBase: DataNetworkInteract) :
    ViewModel() {
    val loadingListBestSeller = MutableLiveData<List<BestSeller>>()
    val loadingListCategory = MutableLiveData<List<DataCategory>>()
    val loadingHomeStore = MutableLiveData<List<HomeStore>>()
    val onClickedEvent = SingleLiveEvent<String>()
    fun onViewCreatedLoadingList() {
        viewModelScope.launch {
            val listPizzaResponse = dataFromDataBase.dataNetworkListInteract().best_seller
            // Log.d("11111111", "${listPizzaResponse[0]}")
            loadingListBestSeller.postValue(listPizzaResponse)
            val listHomeStore = dataFromDataBase.dataNetworkListInteract().home_store
            loadingHomeStore.postValue(listHomeStore)
            val listCategoryResponse = dataFromDataBase.dataCategory
            loadingListCategory.postValue(listCategoryResponse)
        }
    }

    fun onClicked(currencyPosition: String) {
        onClickedEvent.postValue(currencyPosition)
    }
}

@Suppress("UNCHECKED_CAST")
class GeneralScreenViewModelFactory(
    private val interact: DataNetworkInteract
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        GeneralScreenViewModel(interact) as T
}