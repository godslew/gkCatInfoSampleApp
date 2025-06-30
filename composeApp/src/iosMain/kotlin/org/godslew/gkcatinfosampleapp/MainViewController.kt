package org.godslew.gkcatinfosampleapp

import androidx.compose.ui.window.ComposeUIViewController
import org.godslew.gkcatinfosampleapp.di.appModule
import org.godslew.gkcatinfosampleapp.di.iosImageLoaderModule
import org.godslew.gkcatinfosampleapp.di.networkModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController { 
    initKoin()
    App() 
}

private fun initKoin() {
    startKoin {
        modules(appModule, networkModule, iosImageLoaderModule)
    }
}