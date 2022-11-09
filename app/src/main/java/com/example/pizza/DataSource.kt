package com.example.pizza


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
    val price_without: Int,
    val picture: String
)

data class DataCategory(val category: String)

data class DataList(val home_store: List<HomeStore>, val best_seller: List<BestSeller>)
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

class DataSource {
    private val categoryList = listOf(
        DataCategory("Phones"),
        DataCategory("Computer"),
        DataCategory("Health"),
        DataCategory("Books"),
        DataCategory("Phones"),
    )

    fun getCategoryList(): List<DataCategory> {
        return categoryList
    }

}