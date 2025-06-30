package org.godslew.gkcatinfosampleapp.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CatRepository {
    fun getCatInfo(): Flow<CatInfo> = flow {
        delay(1000)
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

data class CatInfo(
    val name: String,
    val age: Int,
    val breed: String,
    val description: String
)