package org.godslew.gkcatinfosampleapp.data.api

import io.ktor.client.call.body
import io.ktor.client.request.parameter
import org.godslew.gkcatinfosampleapp.data.api.response.CatBreedResponse
import org.godslew.gkcatinfosampleapp.data.api.response.CatImageResponse
import org.godslew.gkcatinfosampleapp.data.network.ApiClient
import org.godslew.gkcatinfosampleapp.value.CatBreedId

interface CatApiService {
    suspend fun getBreeds(limit: Int = 10, page: Int = 0): List<CatBreedResponse>
    suspend fun getBreedById(breedId: CatBreedId): CatBreedResponse
    suspend fun searchImages(
        breedIds: String? = null,
        limit: Int = 10,
        page: Int = 0,
        order: String = "DESC",
        hasBreeds: Boolean = false
    ): List<CatImageResponse>
    suspend fun getRandomImage(): CatImageResponse
}

class CatApiServiceImpl(
    private val apiClient: ApiClient
) : CatApiService {

    override suspend fun getBreeds(limit: Int, page: Int): List<CatBreedResponse> {
        return apiClient.request<List<CatBreedResponse>>(
            path = "/breeds"
        ) {
            parameter("limit", limit)
            parameter("page", page)
        }.body()
    }

    override suspend fun getBreedById(breedId: CatBreedId): CatBreedResponse {
        return apiClient.request<CatBreedResponse>(
            path = "/breeds/${breedId.value}"
        ).body()
    }

    override suspend fun searchImages(
        breedIds: String?,
        limit: Int,
        page: Int,
        order: String,
        hasBreeds: Boolean
    ): List<CatImageResponse> {
        return apiClient.request<List<CatImageResponse>>(
            path = "/images/search"
        ) {
            breedIds?.let { parameter("breed_ids", it) }
            parameter("limit", limit)
            parameter("page", page)
            parameter("order", order)
            if (hasBreeds) {
                parameter("has_breeds", 1)
            }
        }.body()
    }

    override suspend fun getRandomImage(): CatImageResponse {
        val response = apiClient.request<List<CatImageResponse>>(
            path = "/images/search"
        ) {
            parameter("limit", 1)
        }
        val images: List<CatImageResponse> = response.body()
        return images.first()
    }
}