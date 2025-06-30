package org.godslew.gkcatinfosampleapp.di

import org.godslew.gkcatinfosampleapp.Platform
import org.godslew.gkcatinfosampleapp.data.CatRepository
import org.godslew.gkcatinfosampleapp.presentation.CatViewModel
import org.godslew.gkcatinfosampleapp.presentation.CatDetailViewModel
import org.koin.dsl.module

val appModule = module {
    single<Platform> { getPlatform() }
    single { CatRepository(get()) }
    factory { CatViewModel(get()) }
    factory { CatDetailViewModel(get()) }
}

expect fun getPlatform(): Platform