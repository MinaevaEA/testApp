package com.example.pizza.general.dugger

import com.example.pizza.general.model.CategoryModel
import dagger.Module
import dagger.Provides


@Module
class DataCategoryModule {
    @Provides
    fun provideDatabaseHelper(): List<CategoryModel> {
        return  listOf(
            CategoryModel("Phones"),
            CategoryModel("Computer"),
            CategoryModel("Health"),
            CategoryModel("Books"),
            CategoryModel("Phones")
        )
    }
}