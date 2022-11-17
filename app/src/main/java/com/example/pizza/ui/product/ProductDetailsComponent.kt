package com.example.pizza.ui.product

import dagger.Subcomponent

@Subcomponent(modules = [ProductDetailsModule::class])
interface ProductDetailsComponent {
    fun injectProductDetailsComponent(ProductDetailsFragment: ProductDetailsFragment) {}
}