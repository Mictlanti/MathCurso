@file:OptIn(ExperimentalMaterial3Api::class)

package com.horizon.matemticascurso.components.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.data.firebase.AuthManager
import com.horizon.matemticascurso.views.components.SpaceW
import com.horizon.matemticascurso.views.components.bodySmall
import com.horizon.matemticascurso.views.components.headLineLargeHome

@Composable
fun titleLargeHome(
    authManager: AuthManager,
    onClick: () -> Unit
) {

    val modiImageProfile = Modifier
        .clip(RoundedCornerShape(10.dp))
        .size(38.dp)
        .shadow(30.dp)
        .clickable { onClick() }

    CenterAlignedTopAppBar(
        title = {
            headLineLargeHome(title = stringResource(id = R.string.app_name))
        },
        actions = {
            ImageProfile(
                authManager,
                modiImageProfile
            )

            SpaceW(6.dp)
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent)
    )
}

@Composable
fun ImageProfile(
    authManager: AuthManager,
    modifier: Modifier
) {

    val user = authManager.getCurrentUser()

    if (user?.photoUrl != null) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(user?.photoUrl)
                .crossfade(true)
                .build(),
            contentDescription = "Image",
            placeholder = painterResource(id = R.drawable.ic_person),
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
    else {
        Image(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "Image",
            modifier = modifier,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
        )
    }
}

@Composable
fun withoutInternet(
    modifier: Modifier,
    text: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        bodySmall(text = text, modifier = Modifier)
        Icon(
            imageVector = Icons.Default.WifiOff,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier.size(20.dp)
        )
    }
}