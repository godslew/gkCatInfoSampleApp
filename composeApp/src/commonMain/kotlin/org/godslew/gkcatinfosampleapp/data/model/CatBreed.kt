package org.godslew.gkcatinfosampleapp.data.model

import org.godslew.gkcatinfosampleapp.value.CatBreedId

data class CatBreed(
    val id: CatBreedId,
    val name: String,
    val altNames: String? = null,
    val origin: String? = null,
    val description: String? = null,
    val lifeSpan: String? = null,
    val temperament: String? = null,
    val wikipediaUrl: String? = null,
    val weight: Weight? = null,
    val affectionLevel: Int? = null,
    val energyLevel: Int? = null,
    val intelligence: Int? = null,
    val socialNeeds: Int? = null,
    val strangerFriendly: Int? = null
)

data class Weight(
    val imperial: String? = null,
    val metric: String? = null
)