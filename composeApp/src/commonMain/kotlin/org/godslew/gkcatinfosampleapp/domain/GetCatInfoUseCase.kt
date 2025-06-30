package org.godslew.gkcatinfosampleapp.domain

import org.godslew.gkcatinfosampleapp.data.CatInfo
import org.godslew.gkcatinfosampleapp.data.CatRepository
import kotlinx.coroutines.flow.Flow

class GetCatInfoUseCase(
    private val catRepository: CatRepository
) {
    operator fun invoke(): Flow<CatInfo> = catRepository.getCatInfo()
}