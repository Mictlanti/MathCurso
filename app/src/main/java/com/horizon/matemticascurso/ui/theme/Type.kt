package com.horizon.matemticascurso.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.horizon.matemticascurso.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val ubuntuFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Ubuntu"),
        fontProvider = provider
    )
)

val salsaFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("salsa"),
        fontProvider = provider
    )
)
val personForTitle = FontFamily(
    Font(
        googleFont = GoogleFont("sedan"),
        fontProvider = provider
    )
)
val personForBody = FontFamily(
    Font(
        googleFont = GoogleFont("Monserrat"),
        fontProvider = provider
    ) //Light 300 italic
)

val abelFont = FontFamily(
    Font(
        googleFont = GoogleFont("Abel"),
        fontProvider = provider
    )
)

val robotoMono = FontFamily(
    Font(
        googleFont = GoogleFont("Roboto Mono"),
        fontProvider = provider
    )
)