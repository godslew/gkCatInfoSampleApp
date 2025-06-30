package org.godslew.gkcatinfosampleapp

import androidx.compose.ui.window.ComposeUIViewController
import org.godslew.gkcatinfosampleapp.di.appModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController { 
    initKoin()
    App() 
}

private fun initKoin() {
    startKoin {
        modules(appModule)
    }
}