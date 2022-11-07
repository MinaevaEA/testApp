package com.example.pizza

import android.app.Application
import com.example.pizza.retrofit.RetrofitServices
import retrofit2.Retrofit

class SubApplication : Application() {
    private lateinit var dataSource: DataSource
    private lateinit var dataFromNetwork: Retrofit

    override fun onCreate() {
        super.onCreate()
        dataSource = DataSource()
        dataFromNetwork = RetrofitServices.getClient()
    }

    fun provideDataSource(): DataSource {
        return dataSource
    }
    fun provideDataFromNetwork(): Retrofit {
        return dataFromNetwork
    }
}