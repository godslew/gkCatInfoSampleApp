package org.godslew.gkcatinfosampleapp.di

import android.content.Context
import coil3.ImageLoader
import coil3.disk.DiskCache
import coil3.disk.directory
import coil3.memory.MemoryCache
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import io.ktor.client.HttpClient
import okio.Path.Companion.toOkioPath
import org.koin.dsl.module

val androidImageLoaderModule = module {
    single {
        val context = get<Context>()
        ImageLoader.Builder(context)
            .components {
                add(KtorNetworkFetcherFactory(get<HttpClient>()))
            }
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context, 0.25)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(context.cacheDir.resolve("image_cache").toOkioPath())
                    .maxSizeBytes(512L * 1024 * 1024) // 512MB
                    .build()
            }
            .logger(DebugLogger())
            .crossfade(true)
            .build()
    }
}