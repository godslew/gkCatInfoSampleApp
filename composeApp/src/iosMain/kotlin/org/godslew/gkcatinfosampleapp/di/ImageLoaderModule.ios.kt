package org.godslew.gkcatinfosampleapp.di

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.disk.DiskCache
import coil3.disk.directory
import coil3.memory.MemoryCache
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import io.ktor.client.HttpClient
import okio.Path.Companion.toPath
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask
import org.koin.dsl.module

val iosImageLoaderModule = module {
    single {
        ImageLoader.Builder(PlatformContext.INSTANCE)
            .components {
                add(KtorNetworkFetcherFactory(get<HttpClient>()))
            }
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(PlatformContext.INSTANCE, 0.25)
                    .build()
            }
            .diskCache {
                val cacheDir = NSSearchPathForDirectoriesInDomains(
                    NSCachesDirectory,
                    NSUserDomainMask,
                    true
                ).firstOrNull() as? String
                
                cacheDir?.let {
                    DiskCache.Builder()
                        .directory("$it/image_cache".toPath())
                        .maxSizeBytes(512L * 1024 * 1024) // 512MB
                        .build()
                }
            }
            .logger(DebugLogger())
            .crossfade(true)
            .build()
    }
}