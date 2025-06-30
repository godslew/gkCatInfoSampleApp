package org.godslew.gkcatinfosampleapp.di

import org.godslew.gkcatinfosampleapp.data.api.CatApiService
import org.godslew.gkcatinfosampleapp.data.api.CatApiServiceImpl
import org.godslew.gkcatinfosampleapp.data.network.ApiClient
import org.godslew.gkcatinfosampleapp.data.network.ApiClientImpl
import org.godslew.gkcatinfosampleapp.data.network.HttpClientFactory
import org.koin.dsl.module

val networkModule = module {
    single { HttpClientFactory().create() }
    
    single<ApiClient> { 
        ApiClientImpl(
            httpClient = get(),
            baseUrl = "https://api.thecatapi.com/v1"
        )
    }
    
    single<CatApiService> {
        CatApiServiceImpl(
            apiClient = get()
        )
    }
}