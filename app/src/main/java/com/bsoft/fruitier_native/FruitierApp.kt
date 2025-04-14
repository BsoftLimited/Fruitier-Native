package com.bsoft.fruitier_native

import android.app.Application
import android.util.Log
import com.bsoft.fruitier_native.utils.AppModule
import com.bsoft.fruitier_native.utils.AppModuleImpl

class FruitierApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "coming inside onCreate")
        appModule = AppModuleImpl(this)
    }

    companion object{
        const val TAG = "FruitierApp"
        lateinit var appModule: AppModule
            private set
    }
}
