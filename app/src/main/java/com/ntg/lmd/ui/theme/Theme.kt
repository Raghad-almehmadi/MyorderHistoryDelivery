package com.ntg.lmd.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
    darkColorScheme(
        primary = PrimaryRed,
        onPrimary = WhiteDark,
        background = DarkBackground,
        onBackground = LightText,
        surface = BackgroundOverlayDark,
        onSurface = LightText,
        error = ErrorRedDark,
        onError = WhiteDark,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = PrimaryRed,
        onPrimary = White,
        background = LightGray,
        onBackground = DarkGray,
        surface = surfaceWhite,
        onSurface = DarkGray,
        error = ErrorRed,
        onError = White,
    )

@Composable
fun lmdTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
