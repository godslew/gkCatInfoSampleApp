package org.godslew.gkcatinfosampleapp.data.mapper

import org.godslew.gkcatinfosampleapp.data.api.response.CatBreedResponse
import org.godslew.gkcatinfosampleapp.data.api.response.CatImageResponse
import org.godslew.gkcatinfosampleapp.data.api.response.WeightResponse
import org.godslew.gkcatinfosampleapp.data.model.CatBreed
import org.godslew.gkcatinfosampleapp.data.model.CatImage
import org.godslew.gkcatinfosampleapp.data.model.Weight
import org.godslew.gkcatinfosampleapp.value.CatBreedId
import org.godslew.gkcatinfosampleapp.value.CatImageId

fun CatBreedResponse.toDomain(): CatBreed {
    return CatBreed(
        id = CatBreedId(id),
        name = name,
        altNames = altNames,
        origin = origin,
        description = description,
        lifeSpan = lifeSpan,
        temperament = temperament,
        wikipediaUrl = wikipediaUrl,
        weight = weight?.toDomain(),
        affectionLevel = affectionLevel,
        energyLevel = energyLevel,
        intelligence = intelligence,
        socialNeeds = socialNeeds,
        strangerFriendly = strangerFriendly
    )
}

fun WeightResponse.toDomain(): Weight {
    return Weight(
        imperial = imperial,
        metric = metric
    )
}

fun CatImageResponse.toDomain(): CatImage {
    return CatImage(
        id = CatImageId(id),
        url = url,
        width = width,
        height = height,
        breeds = breeds?.map { it.toDomain() }
    )
}
