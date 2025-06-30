package org.godslew.gkcatinfosampleapp.data

import org.godslew.gkcatinfosampleapp.data.api.CatApiService
import org.godslew.gkcatinfosampleapp.data.model.CatBreed
import org.godslew.gkcatinfosampleapp.data.model.CatImage

class CatRepository(
    private val catApiService: CatApiService
) {
    suspend fun getBreeds(limit: Int = 10, page: Int = 0): List<CatBreed> {
        return catApiService.getBreeds(limit, page)
    }
    
    suspend fun searchImages(breedId: String? = null, limit: Int = 10, hasBreeds: Boolean = true): List<CatImage> {
        return catApiService.searchImages(breedIds = breedId, limit = limit, order = "RANDOM", hasBreeds = hasBreeds)
    }
    
    suspend fun getRandomCatImage(): CatImage {
        return catApiService.getRandomImage()
    }
    
    suspend fun getBreedById(breedId: String): CatBreed {
        return catApiService.getBreedById(breedId)
    }
}