package org.godslew.gkcatinfosampleapp.navigation

import platform.Foundation.NSString
import platform.Foundation.stringByAddingPercentEncodingWithAllowedCharacters
import platform.Foundation.stringByRemovingPercentEncoding
import platform.Foundation.NSCharacterSet

actual fun encodeUrl(value: String): String {
    return (value as NSString).stringByAddingPercentEncodingWithAllowedCharacters(
        NSCharacterSet.alphanumericCharacterSet
    ) ?: value
}

actual fun decodeUrl(value: String): String {
    return (value as NSString).stringByRemovingPercentEncoding ?: value
}