package org.godslew.gkcatinfosampleapp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF6BB6FF),
    onPrimary = Color(0xFF003258),
    primaryContainer = Color(0xFF00497D),
    onPrimaryContainer = Color(0xFFD3E4FF),
    secondary = Color(0xFFBCC7DB),
    onSecondary = Color(0xFF263141),
    secondaryContainer = Color(0xFF3C4758),
    onSecondaryContainer = Color(0xFFD8E3F7),
    surface = Color(0xFF1A1C1E),
    onSurface = Color(0xFFE2E2E6),
    background = Color(0xFF1A1C1E),
    onBackground = Color(0xFFE2E2E6),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF0061A4),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFD3E4FF),
    onPrimaryContainer = Color(0xFF001C38),
    secondary = Color(0xFF535F70),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFD8E3F7),
    onSecondaryContainer = Color(0xFF101C2B),
    surface = Color(0xFFFBFCFF),
    onSurface = Color(0xFF1A1C1E),
    background = Color(0xFFFBFCFF),
    onBackground = Color(0xFF1A1C1E),
    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}