package org.godslew.gkcatinfosampleapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatBreed(
    val id: String,
    val name: String,
    @SerialName("alt_names") val altNames: String? = null,
    val origin: String? = null,
    val description: String? = null,
    @SerialName("life_span") val lifeSpan: String? = null,
    val temperament: String? = null,
    @SerialName("wikipedia_url") val wikipediaUrl: String? = null,
    val weight: Weight? = null,
    @SerialName("affection_level") val affectionLevel: Int? = null,
    @SerialName("energy_level") val energyLevel: Int? = null,
    val intelligence: Int? = null,
    @SerialName("social_needs") val socialNeeds: Int? = null,
    @SerialName("stranger_friendly") val strangerFriendly: Int? = null
)

@Serializable
data class Weight(
    val imperial: String? = null,
    val metric: String? = null
)