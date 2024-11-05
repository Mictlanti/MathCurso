package com.horizon.matemticascurso.views.favoriteView

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.horizon.matemticascurso.views.components.headLineMediumWidthModi
import com.horizon.matemticascurso.vms.FavoriteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(favoriteVM: FavoriteViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Arrow Back"
                        )
                    }
                },
                title = { headLineMediumWidthModi(title = "Favoritos", modifier = Modifier) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { paddingValues ->
        BodyFavorite(paddingValues, favoriteVM)
    }
}

@Composable
fun BodyFavorite(
    paddingValues: PaddingValues,
    favoriteVM: FavoriteViewModel
) {

    val topicsFav by favoriteVM.mathList.collectAsState()

    LazyColumn(contentPadding = paddingValues) {
        items(topicsFav) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable { }
            ) {
                headLineMediumWidthModi(title = item.title, modifier = Modifier)
            }
        }
    }
}