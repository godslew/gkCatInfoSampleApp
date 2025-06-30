# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Ktor
-keep class io.ktor.** { *; }
-keep class io.ktor.client.** { *; }
-keepclassmembers class io.ktor.** { volatile <fields>; }
-keepclassmembers class io.ktor.client.** { volatile <fields>; }
-dontwarn kotlinx.atomicfu.**
-dontwarn io.netty.**
-dontwarn com.typesafe.**
-dontwarn org.slf4j.**

# Kotlin serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

-keep,includedescriptorclasses class org.godslew.gkcatinfosampleapp.**$$serializer { *; }
-keepclassmembers class org.godslew.gkcatinfosampleapp.** {
    *** Companion;
}
-keepclasseswithmembers class org.godslew.gkcatinfosampleapp.** {
    kotlinx.serialization.KSerializer serializer(...);
}