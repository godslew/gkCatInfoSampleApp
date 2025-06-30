package org.godslew.gkcatinfosampleapp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import org.godslew.gkcatinfosampleapp.BuildKonfig

interface ApiClient {
    suspend fun <T> request(
        path: String,
        method: HttpMethod = HttpMethod.Get,
        block: HttpRequestBuilder.() -> Unit = {}
    ): HttpResponse
}

class ApiClientImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : ApiClient {
    
    override suspend fun <T> request(
        path: String,
        method: HttpMethod,
        block: HttpRequestBuilder.() -> Unit
    ): HttpResponse {
        return httpClient.request {
            url(baseUrl + path)
            this.method = method
            header("x-api-key", BuildKonfig.CAT_API_KEY)
            block()
        }
    }
}