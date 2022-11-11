package com.example.pizza.ui.mycart

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pizza.*
import kotlinx.coroutines.launch


class MyCartViewModel(private val dataFromDataBase: DataNetworkMyCartInteract) :
    ViewModel() {
    val loadingProductDetails = MutableLiveData<DataMyCart>()
    val loadingImages = MutableLiveData<List<DataBasket>>()
    fun onViewCreatedLoadingProductDetails() {
        viewModelScope.launch {
            try {
                val dataProductDetails = dataFromDataBase.dataMyCartInteract()
                val images = dataProductDetails.basket
                Log.d("5555555", "${dataProductDetails}")
                loadingProductDetails.postValue(dataProductDetails)
                loadingImages.postValue(images)


            } catch (e: Exception) {
                Log.d("2222", "$e")
                Log.d("2222", "${e.getLocalizedMessage()}")
                Log.d("2222", "${e.cause}")
            }
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