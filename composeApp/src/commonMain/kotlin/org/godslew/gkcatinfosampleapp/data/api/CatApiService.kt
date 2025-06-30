package org.godslew.gkcatinfosampleapp.data.api

import io.ktor.client.call.body
import io.ktor.client.request.parameter
import org.godslew.gkcatinfosampleapp.data.model.CatBreed
import org.godslew.gkcatinfosampleapp.data.model.CatImage
import org.godslew.gkcatinfosampleapp.data.network.ApiClient

interface CatApiService {
    suspend fun getBreeds(limit: Int = 10, page: Int = 0): List<CatBreed>
    suspend fun getBreedById(breedId: String): CatBreed
    suspend fun searchImages(
        breedIds: String? = null,
        limit: Int = 10,
        page: Int = 0,
        order: String = "DESC"
    ): List<CatImage>
    suspend fun getRandomImage(): CatImage
}

class CatApiServiceImpl(
    private val apiClient: ApiClient
) : CatApiService {
    
    override suspend fun getBreeds(limit: Int, page: Int): List<CatBreed> {
        return apiClient.request<List<CatBreed>>(
            path = "/breeds"
        ) {
            parameter("limit", limit)
            parameter("page", page)
        }.body()
    }
    
    override suspend fun getBreedById(breedId: String): CatBreed {
        return apiClient.request<CatBreed>(
            path = "/breeds/$breedId"
        ).body()
    }
    
    override suspend fun searchImages(
        breedIds: String?,
        limit: Int,
        page: Int,
        order: String
    ): List<CatImage> {
        return apiClient.request<List<CatImage>>(
            path = "/images/search"
        ) {
            breedIds?.let { parameter("breed_ids", it) }
            parameter("limit", limit)
            parameter("page", page)
            parameter("order", order)
        }.body()
    }
    
    override suspend fun getRandomImage(): CatImage {
        val response = apiClient.request<List<CatImage>>(
            path = "/images/search"
        ) {
            parameter("limit", 1)
        }
        val images: List<CatImage> = response.body()
        return images.first()
    }
}