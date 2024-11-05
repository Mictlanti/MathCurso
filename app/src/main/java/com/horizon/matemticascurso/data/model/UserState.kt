package com.horizon.matemticascurso.data.model

import androidx.compose.ui.graphics.Color
import com.horizon.matemticascurso.ui.theme.backgroundDark
import com.horizon.matemticascurso.ui.theme.backgroundLight
import com.horizon.matemticascurso.ui.theme.backgroundNewDark
import com.horizon.matemticascurso.ui.theme.backgroundNewLight
import com.horizon.matemticascurso.ui.theme.backgroundRelaxDark
import com.horizon.matemticascurso.ui.theme.backgroundRelaxLight

data class UserState(
    val listColorsLight: List<Color> = listOf(
        backgroundLight,
        backgroundNewLight,
        backgroundRelaxLight,
        backgroundDark,
        backgroundNewDark,
        backgroundRelaxDark
    ),
    val indexColor: Int = 0,
    val background: Color = backgroundDark,
    val isDarkMode: Boolean = true
)
