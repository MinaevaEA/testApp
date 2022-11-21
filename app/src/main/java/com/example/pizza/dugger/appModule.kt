package com.example.pizza.general

import android.app.Application
import android.content.Context
import com.example.pizza.retrofit.RetrofitServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(private val application: Application) {
    private lateinit var dataFromNetwork: Retrofit

    @Provides
    fun providesApplicationContext(): Context = application

    @Provides
    fun providesApplication(): Application = application

    @Provides
    fun provideDataFromNetwork(): Retrofit {
        val baseUrl = "https://run.mocky.io/"

        dataFromNetwork = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return dataFromNetwork
    }

    @Provides
    fun provideApi(retrofit: Retrofit): RetrofitServices {
        return retrofit.create(RetrofitServices::class.java)
    }


}
