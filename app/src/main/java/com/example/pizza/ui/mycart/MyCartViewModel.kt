package com.example.pizza.ui.mycart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pizza.*
import kotlinx.coroutines.launch


class MyCartViewModel(private val dataFromDataBase: DataNetworkMyCartInteract) :
    ViewModel() {
    val loadingProductDetails = MutableLiveData<DataMyCart>()
    val loadingListDataBasket = MutableLiveData<List<DataBasket>>()
    val backToMain = SingleLiveEvent<Unit>()
    fun onViewCreatedLoadingProductDetails() {
        viewModelScope.launch {
            val dataProductDetails = dataFromDataBase.dataMyCartInteract()
            val listDataBasket = dataProductDetails.basket
            loadingProductDetails.postValue(dataProductDetails)
            loadingListDataBasket.postValue(listDataBasket)
            backToMain.postValue(Unit)
        }
    }
}

@Suppress("UNCHECKED_CAST")
class MyCartViewModelFactory(
    private val interact: DataNetworkMyCartInteract
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MyCartViewModel(interact) as T
}