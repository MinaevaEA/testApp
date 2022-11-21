package com.example.pizza.mycart.dugger

import com.example.pizza.mycart.ui.MyCartFragment
import dagger.Subcomponent

@Subcomponent(modules = [MyCartModule::class])
interface MyCartComponent {
    fun injectMyCartFragment(MyCartFragment: MyCartFragment) {}
}