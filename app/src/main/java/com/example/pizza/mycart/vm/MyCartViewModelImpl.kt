package com.example.pizza.mycart.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pizza.*
import com.example.pizza.mycart.interactor.MyCartInteractor
import com.example.pizza.mycart.model.BasketModel
import com.example.pizza.mycart.model.MyCartModel
import kotlinx.coroutines.launch


class MyCartViewModelImpl(private val myCartInteractor: MyCartInteractor
) :
    ViewModel() , MyCartViewModel{
    override val myCartModel = MutableLiveData<MyCartModel>()
    override val listBasketItem = MutableLiveData<List<BasketModel>>()
    override val backToGeneralScreen = SingleLiveEvent<Unit>()
    override fun onViewCreated() {
        viewModelScope.launch {
            val myCartModelRequest = myCartInteractor.getMyCart()
            val listBasketModelRequest = myCartModelRequest.basket
            myCartModel.postValue(myCartModelRequest)
            listBasketItem.postValue(listBasketModelRequest)

        }
    }
    override fun onClickedBackToGeneral(){
        backToGeneralScreen.postValue(Unit)
    }
}

@Suppress("UNCHECKED_CAST")
class MyCartViewModelFactory(
    private val myCartInteractor: MyCartInteractor
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MyCartViewModelImpl(myCartInteractor) as T
}