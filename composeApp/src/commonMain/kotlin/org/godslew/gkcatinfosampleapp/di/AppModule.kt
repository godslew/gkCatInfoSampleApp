package org.godslew.gkcatinfosampleapp.di

import org.godslew.gkcatinfosampleapp.Greeting
import org.godslew.gkcatinfosampleapp.Platform
import org.godslew.gkcatinfosampleapp.data.CatRepository
import org.godslew.gkcatinfosampleapp.domain.GetCatInfoUseCase
import org.godslew.gkcatinfosampleapp.presentation.CatViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single<Platform> { getPlatform() }
    singleOf(::Greeting)
    single { CatRepository(get()) }
    factoryOf(::GetCatInfoUseCase)
    factoryOf(::CatViewModel)
}

expect fun getPlatform(): Platform