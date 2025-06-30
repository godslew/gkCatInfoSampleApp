package org.godslew.gkcatinfosampleapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CatImage(
    val id: String,
    val url: String,
    val width: Int? = null,
    val height: Int? = null,
    val breeds: List<CatBreed>? = null
)