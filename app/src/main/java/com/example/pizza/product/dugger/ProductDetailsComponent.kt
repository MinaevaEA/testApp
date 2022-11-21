package com.example.pizza.product.dugger

import com.example.pizza.product.ui.ProductDetailsFragment
import dagger.Subcomponent

@Subcomponent(modules = [ProductDetailsModule::class])
interface ProductDetailsComponent {
    fun injectProductDetailsComponent(ProductDetailsFragment: ProductDetailsFragment) {}
}