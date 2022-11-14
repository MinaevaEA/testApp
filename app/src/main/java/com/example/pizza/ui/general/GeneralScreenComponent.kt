package com.example.pizza.ui.general

import dagger.Subcomponent

@Subcomponent(modules = [GeneralScreenModule::class, DataCategoryModule::class])
interface GeneralScreenComponent {
    fun injectGeneralScreenFragment(GeneralScreenFragment: GeneralScreenFragment) {}

}