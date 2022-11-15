package com.example.pizza.ui.general

import com.example.pizza.DataCategory
import dagger.Module
import dagger.Provides


@Module
class DataCategoryModule {
    @Provides
    fun provideDatabaseHelper(): List<DataCategory> {
        return  listOf(
            DataCategory("Phones",),
            DataCategory("Computer"),
            DataCategory("Health"),
            DataCategory("Books"),
            DataCategory("Phones"))
    }
}