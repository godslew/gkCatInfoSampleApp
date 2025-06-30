package org.godslew.gkcatinfosampleapp.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.godslew.gkcatinfosampleapp.data.api.CatApiService
import org.godslew.gkcatinfosampleapp.data.model.CatBreed
import org.godslew.gkcatinfosampleapp.data.model.CatImage

class CatRepository(
    private val catApiService: CatApiService
) {
    fun getCatInfo(): Flow<CatInfo> = flow {
        try {
            val breeds = catApiService.getBreeds(limit = 1)
            if (breeds.isNotEmpty()) {
                val breed = breeds.first()
                emit(
                    CatInfo(
                        name = breed.name,
                        age = 3, // APIにはないのでダミー値
                        breed = breed.origin ?: "Unknown",
                        description = breed.description ?: "No description available"
                    )
                )
            }
        } catch (e: Exception) {
            // エラー時はダミーデータを返す
            emit(
                CatInfo(
                    name = "Tama",
                    age = 3,
                    breed = "Scottish Fold",
                    description = "A friendly and playful cat"
                )
            )
        }
    }
    
    suspend fun getBreeds(limit: Int = 10, page: Int = 0): List<CatBreed> {
        return catApiService.getBreeds(limit, page)
    }
    
    suspend fun searchImages(breedId: String? = null, limit: Int = 10): List<CatImage> {
        return catApiService.searchImages(breedIds = breedId, limit = limit)
    }
    
    suspend fun getRandomCatImage(): CatImage {
        return catApiService.getRandomImage()
    }
}

data class CatInfo(
    val name: String,
    val age: Int,
    val breed: String,
    val description: String
)