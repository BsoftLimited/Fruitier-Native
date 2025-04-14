package com.bsoft.fruitier_native.utils;

import android.content.Context;

interface AppModule {
    val repository: Repository
    val dataStoreManager: DataStoreManager
}

class AppModuleImpl(context:Context) : AppModule{
    override val repository: Repository by lazy { Repository() }
    override val dataStoreManager: DataStoreManager by lazy { DataStoreManager(context) }
}
