package com.example.pizza.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pizza.DataCategory
import com.example.pizza.DataList
import com.example.pizza.DataPizza
import kotlinx.coroutines.launch


class MenuViewModel(private val dataFromDataBase: DataNetworkInteract) :
    ViewModel() {
    val loadingListPizza = MutableLiveData<List<DataPizza>>()
    val loadingListCategory = MutableLiveData<List<DataCategory>>()
    fun onViewCreatedPizza() {
        //TODO corutineExсeptionHandler, отключить интернет, повернуть экран
        viewModelScope.launch {
            try {
            val listPizzaResponse = dataFromDataBase.dataNetworkListInteract()!!.DataPizza
             Log.d("11111111", "${listPizzaResponse[0]}")
            loadingListPizza.postValue(listPizzaResponse)

              } catch (e: Exception) {
            Log.d("2222", "$e")
            Log.d("2222", "${e.getLocalizedMessage()}")
            Log.d("2222", "${e.cause}")
        }

            val listCategoryResponse = dataFromDataBase.dataCategory
            loadingListCategory.postValue(listCategoryResponse)
        }
    }
}

@Suppress("UNCHECKED_CAST")
class PizzaListViewModelFactory(
    private val interact: DataNetworkInteract
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MenuViewModel(interact) as T
}