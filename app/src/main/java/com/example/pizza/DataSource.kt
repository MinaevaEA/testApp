package com.example.pizza

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.google.gson.annotations.SerializedName
import javax.inject.Named


data class HomeStore(
    val id: Int,
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)

data class BestSeller(
    val id: Int,
    val is_favorite: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)

data class DataCategory( val category: String)


data class DataList(
    @SerializedName("home_store")
    val homeStore: List<HomeStore>,
    val best_seller: List<BestSeller>)

data class DataProductDetails(
    val CPU: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val id: Int,
    val is_Favorite: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String,
    val images: List<String>
)

data class DataMyCart(
    val basket: List<DataBasket>,
    val delivery: String,
    val id: String,
    val total: String
)

data class DataBasket(val images: String, val id: Int, val price: Int, val title: String)

@Named("FooDependency")
class DataSource {
/*
    private val categoryList = listOf(
        DataCategory("Phones","@drawable/vector"),
        DataCategory("Computer","@drawable/vector"),
        DataCategory("Health","@drawable/vector"),
        DataCategory("Books","@drawable/vector"),
        DataCategory("Phones","@drawable/vector"),
    )

    fun getCategoryList(): List<DataCategory> {
        return categoryList
    }
*/

}