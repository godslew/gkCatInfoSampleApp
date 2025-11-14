package org.godslew.gkcatinfosampleapp.data.model

import org.godslew.gkcatinfosampleapp.value.CatImageId

data class CatImage(
    val id: CatImageId,
    val url: String,
    val width: Int? = null,
    val height: Int? = null,
    val breeds: List<CatBreed>? = null
)