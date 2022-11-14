package com.example.pizza.dugger

import com.example.pizza.ui.general.AppModule
import com.example.pizza.ui.general.GeneralScreenComponent
import com.example.pizza.ui.mycart.MyCartComponent
import com.example.pizza.ui.product.ProductDetailsComponent
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