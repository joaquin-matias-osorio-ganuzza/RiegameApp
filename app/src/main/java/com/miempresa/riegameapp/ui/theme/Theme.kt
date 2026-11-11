package com.miempresa.riegameapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(

)

private val LightColorScheme = lightColorScheme(

    primary = ColorBotonRegarPlanta,
    onPrimary = Color.White,

    primaryContainer = ColorNotificacion,
    onPrimaryContainer = ColorTextoPrincipal,

    secondary = ColorBotonFABAgregarPlanta,
    onSecondary = Color.Black,

    tertiary = ColorVerdeGrisaceo,
    onTertiary = ColorBlancoCalido,

    background = ColorPrincipal,

    surface = ColorBlancoTarjetas,
    onSurface = ColorTextosSecundarios,

    surfaceVariant = ColorVerdeClaro,
    onSurfaceVariant = ColorTextoHoy,

    outline = ColorBorde,
    outlineVariant = ColorGrisClaro
)

val ColorScheme.colorTransparente: Color
    get() = Color(0x00000000)

@Composable
fun RiegameAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    //dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}