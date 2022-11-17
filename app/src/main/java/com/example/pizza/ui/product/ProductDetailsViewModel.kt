package com.example.pizza.ui.product

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
            val dataProductDetails = dataFromDataBase.dataNetworkListInteract()
            val images = dataProductDetails.images
            loadingProductDetails.postValue(dataProductDetails)
            loadingImages.postValue(images)
            backToMain.postValue(Unit)
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
