package org.godslew.gkcatinfosampleapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatBreed(
    val id: String,
    val name: String,
    val origin: String? = null,
    val description: String? = null,
    @SerialName("life_span") val lifeSpan: String? = null,
    val temperament: String? = null,
    @SerialName("wikipedia_url") val wikipediaUrl: String? = null,
    val weight: Weight? = null
)

@Serializable
data class Weight(
    val imperial: String? = null,
    val metric: String? = null
)