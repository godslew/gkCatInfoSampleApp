package org.godslew.gkcatinfosampleapp.data

import org.godslew.gkcatinfosampleapp.data.api.CatApiService
import org.godslew.gkcatinfosampleapp.data.mapper.toDomain
import org.godslew.gkcatinfosampleapp.data.model.CatBreed
import org.godslew.gkcatinfosampleapp.data.model.CatImage
import org.godslew.gkcatinfosampleapp.value.CatBreedId

class CatRepository(
    private val catApiService: CatApiService
) {
    suspend fun getBreeds(limit: Int = 10, page: Int = 0): List<CatBreed> {
        return catApiService.getBreeds(limit, page).map { it.toDomain() }
    }

    suspend fun searchImages(breedId: String? = null, limit: Int = 10, hasBreeds: Boolean = true): List<CatImage> {
        return catApiService.searchImages(breedIds = breedId, limit = limit, order = "RANDOM", hasBreeds = hasBreeds)
            .map { it.toDomain() }
    }

    suspend fun getRandomCatImage(): CatImage {
        return catApiService.getRandomImage().toDomain()
    }

    suspend fun getBreedById(breedId: CatBreedId): CatBreed {
        return catApiService.getBreedById(breedId).toDomain()
    }
}