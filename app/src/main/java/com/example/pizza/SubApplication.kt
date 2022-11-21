package com.example.pizza

import android.app.Application
import com.example.pizza.dugger.AppComponent
import com.example.pizza.dugger.DaggerAppComponent
import com.example.pizza.general.AppModule

class SubApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .buildAppComp()
    }
}