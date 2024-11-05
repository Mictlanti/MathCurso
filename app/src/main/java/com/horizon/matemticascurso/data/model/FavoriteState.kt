package com.horizon.matemticascurso.data.model

import com.horizon.matemticascurso.AppScreens

data class FavoriteState(
    val showFavorite : Boolean = false,
    val title: String = "",
    val navigation: AppScreens = AppScreens.homeScreenRoute
)