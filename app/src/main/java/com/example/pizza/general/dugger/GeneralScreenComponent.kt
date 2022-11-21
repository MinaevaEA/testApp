package com.example.pizza.general.dugger

import com.example.pizza.general.ui.GeneralScreenFragment
import dagger.Subcomponent

@Subcomponent(modules = [GeneralScreenModule::class, DataCategoryModule::class])
interface GeneralScreenComponent {
    fun injectGeneralScreenFragment(GeneralScreenFragment: GeneralScreenFragment) {}

}