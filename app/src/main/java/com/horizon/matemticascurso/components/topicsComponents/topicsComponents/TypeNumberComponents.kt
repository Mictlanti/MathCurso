package com.horizon.matemticascurso.components.topicsComponents.topicsComponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.horizon.matemticascurso.ui.theme.robotoMono

@Composable
fun RobotoMono(
    text: String,
    size: TextUnit = 15.sp,
    fontStyle: FontStyle = FontStyle.Italic
) {
    Text(
        text = text,
        fontFamily = robotoMono,
        fontSize = size,
        fontWeight = FontWeight.W300,
        fontStyle = fontStyle
    )
}