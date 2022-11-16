package com.example.pizza.ui.product

import android.util.Log
import androidx.lifecycle.*
import com.example.pizza.DataProductDetails
import com.example.pizza.SingleLiveEvent
import kotlinx.coroutines.launch

class ProductDetailsViewModel(private val dataFromDataBase: DataNetworkDetailsInteract) :
    ViewModel() {

    val loadingProductDetails = MutableLiveData<DataProductDetails>()
    val loadingImages = MutableLiveData<List<String>>()
     val backToMain = SingleLiveEvent<Unit>()
    fun onViewCreatedLoadingProductDetails() {
        viewModelScope.launch {
            try {
                val dataProductDetails = dataFromDataBase.dataNetworkListInteract()!!
                val images = dataProductDetails.images
                Log.d("11111111", "${dataProductDetails}")
                loadingProductDetails.postValue(dataProductDetails)
                loadingImages.postValue(images)
                backToMain.postValue(Unit)

            } catch (e: Exception) {
                Log.d("101010101", "$e")
                Log.d("10101010101", "${e.getLocalizedMessage()}")
                Log.d("101010101", "${e.cause}")
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class ProductDetailsViewModelFactory(
    private val interact: DataNetworkDetailsInteract
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ProductDetailsViewModel(interact) as T
}
