package org.godslew.gkcatinfosampleapp.data.api.response

import kotlinx.serialization.Serializable

@Serializable
data class CatImageResponse(
    val id: String,
    val url: String,
    val width: Int? = null,
    val height: Int? = null,
    val breeds: List<CatBreedResponse>? = null
)
