package org.godslew.gkcatinfosampleapp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

actual class HttpClientFactory {
    actual fun create(): HttpClient {
        return createHttpClient(HttpClient(Darwin))
    }
}