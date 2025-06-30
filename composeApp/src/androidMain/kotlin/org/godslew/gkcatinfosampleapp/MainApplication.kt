package org.godslew.gkcatinfosampleapp

import android.app.Application
import org.godslew.gkcatinfosampleapp.di.appModule
import org.godslew.gkcatinfosampleapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule, networkModule)
        }
    }
}