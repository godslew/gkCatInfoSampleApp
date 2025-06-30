package org.godslew.gkcatinfosampleapp.di

import org.godslew.gkcatinfosampleapp.AndroidPlatform
import org.godslew.gkcatinfosampleapp.Platform

actual fun getPlatform(): Platform = AndroidPlatform()