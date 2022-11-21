package com.example.pizza.product.vm

import androidx.lifecycle.*
import com.example.pizza.SingleLiveEvent
import com.example.pizza.product.interactor.ProductDetailsInteractor
import com.example.pizza.product.model.ProductDetailsModel
import kotlinx.coroutines.launch

class ProductDetailsViewModelImpl(private val productDetailsInteractor: ProductDetailsInteractor) :
    ViewModel() , ProductDetailsViewModel {

    override val productDetailsModel = MutableLiveData<ProductDetailsModel>()
    override val images = MutableLiveData<List<String>>()
    override val backToGeneralScreen = SingleLiveEvent<Unit>()

    override fun onViewCreated() {
        viewModelScope.launch {
            val productDetailsRequest = productDetailsInteractor.getProductDetails()
            val imagesRequest = productDetailsRequest.images
            productDetailsModel.postValue(productDetailsRequest)
            images.postValue(imagesRequest)

        }
    }
    override fun onClickedBackToGeneral(){
        backToGeneralScreen.postValue(Unit)
    }

}

@Suppress("UNCHECKED_CAST")
class ProductDetailsViewModelFactory(
    private val productDetailsInteractor: ProductDetailsInteractor
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ProductDetailsViewModelImpl(productDetailsInteractor) as T
}
