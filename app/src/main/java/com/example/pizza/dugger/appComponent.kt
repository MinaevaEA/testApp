package com.example.pizza.dugger

import com.example.pizza.general.AppModule
import com.example.pizza.general.dugger.GeneralScreenComponent
import com.example.pizza.mycart.dugger.MyCartComponent
import com.example.pizza.product.dugger.ProductDetailsComponent
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun getGeneralScreenComponent(): GeneralScreenComponent
    fun getMyCartComponent(): MyCartComponent
    fun getProductDetailsComponent(): ProductDetailsComponent

    @Component.Builder
    interface AppCompBuilder {
        fun buildAppComp(): AppComponent
        fun appModule(appModule: AppModule): AppCompBuilder

    }

}