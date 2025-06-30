package org.godslew.gkcatinfosampleapp.navigation

import kotlinx.serialization.Serializable

@Serializable
data object Gallery

@Serializable
data class Detail(
    val imageId: String,
    val imageUrl: String,
    val breedId: String = ""
)