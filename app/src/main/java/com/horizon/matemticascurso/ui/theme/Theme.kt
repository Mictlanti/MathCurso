package com.horizon.matemticascurso.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.fontResource
import androidx.core.view.WindowCompat
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.vms.UserStateVM

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    primaryContainer = primaryContainerLight,
    tertiary = tertiaryLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    outline = outlineLight,
)

private val newLightScheme = lightColorScheme(
    primary = primaryNewLight,
    primaryContainer = primaryContainerLight,
    tertiary = tertiaryNewLight,
    background = backgroundNewLight,
    onBackground = onBackgroundNewLight,
    outline = outlineNewLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    primaryContainer = primaryContainerDark,
    tertiary = tertiaryDark,
    errorContainer = errorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    outline = outlineDark,
)

private val newDarkScheme = darkColorScheme(
    primary = primaryNewDark,
    primaryContainer = primaryContainerDark,
    tertiary = tertiaryNewDark,
    errorContainer = errorContainerNewDark,
    background = backgroundNewDark,
    onBackground = onBackgroundNewDark,
    outline = outlineNewDark,
)

private val lightRelaxScheme = lightColorScheme(
    primary = primaryRelaxLight,
    primaryContainer = primaryContainerLight,
    tertiary = tertiaryRelaxLight,
    background = backgroundRelaxLight,
    onBackground = onBackgroundRelaxLight,
    outline = outlineRelaxLight,
)

private val darkRelaxScheme = darkColorScheme(
    primary = primaryRelaxDark,
    primaryContainer = primaryContainerDark,
    tertiary = tertiaryRelaxDark,
    errorContainer = errorContainerRelaxDark,
    background = backgroundRelaxDark,
    onBackground = onBackgroundRelaxDark,
    outline = outlineRelaxDark,
)

@Composable
fun AppTheme(
    //darkTheme: Boolean = isSystemInDarkTheme(),
    userStateVM: UserStateVM,
    content: @Composable() () -> Unit,
) {
    //val colorScheme = if (darkTheme) darkRelaxScheme else lightRelaxScheme
    val indexColor = userStateVM.state.collectAsState().value.indexColor
    val changeColor = when(indexColor) {
        0 -> lightScheme
        1 -> newLightScheme
        2 -> lightRelaxScheme
        3 -> darkScheme
        4 -> newDarkScheme
        5 -> darkRelaxScheme
        else -> darkScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = changeColor.background.toArgb()
            //WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = changeColor.background
            window.navigationBarColor = changeColor.background.toArgb()
        }
    }

    MaterialTheme(
        colorScheme = changeColor, // Asegúrate de que Typography esté correctamente definido
        content = content
    )
}