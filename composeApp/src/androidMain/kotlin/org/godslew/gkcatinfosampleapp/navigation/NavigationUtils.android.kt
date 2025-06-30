package org.godslew.gkcatinfosampleapp.navigation

import java.net.URLEncoder
import java.net.URLDecoder

actual fun encodeUrl(value: String): String {
    return URLEncoder.encode(value, "UTF-8")
}

actual fun decodeUrl(value: String): String {
    return URLDecoder.decode(value, "UTF-8")
}