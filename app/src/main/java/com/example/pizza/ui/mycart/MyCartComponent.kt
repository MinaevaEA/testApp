package com.example.pizza.ui.mycart

import dagger.Subcomponent

@Subcomponent(modules = [MyCartModule::class])
interface MyCartComponent {
    fun injectMyCartFragment(MyCartFragment: MyCartFragment) {}
}