package org.godslew.gkcatinfosampleapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform