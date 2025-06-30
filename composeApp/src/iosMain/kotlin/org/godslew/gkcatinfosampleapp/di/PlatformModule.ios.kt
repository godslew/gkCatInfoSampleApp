package org.godslew.gkcatinfosampleapp.di

import org.godslew.gkcatinfosampleapp.IOSPlatform
import org.godslew.gkcatinfosampleapp.Platform

actual fun getPlatform(): Platform = IOSPlatform()