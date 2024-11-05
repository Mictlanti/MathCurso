package com.horizon.matemticascurso.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.components.profileComponents.ProfileView
import com.horizon.matemticascurso.components.profileComponents.ThemeSwitch
import com.horizon.matemticascurso.data.firebase.AuthManager
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.SpaceW
import com.horizon.matemticascurso.views.components.TextAbel
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.vms.UserStateVM


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreenRoute(
    profile: Boolean,
    onDissMiss: () -> Unit,
    authManager: AuthManager,
    userStateVM: UserStateVM,
    navController: NavController
) {
    val modalState = rememberModalBottomSheetState()
    if (profile) {
        ModalBottomSheet(
            sheetState = modalState,
            onDismissRequest = { onDissMiss() },
            dragHandle = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomSheetDefaults.DragHandle()
                    TextAbel(text = stringResource(id = R.string.settings), size = 35.sp)
                    SpaceH()
                    Divider()
                    SpaceH()
                }
            },
            containerColor = MaterialTheme.colorScheme.background,
            shape = MaterialTheme.shapes.extraLarge
        ) {
            profileScreen(authManager, userStateVM, navController)
        }
    }
}

@Composable
fun profileScreen(
    authManager: AuthManager,
    userStateVM: UserStateVM,
    navController: NavController
) {

    var exitSession by remember { mutableStateOf(false) }
    val state by userStateVM.state.collectAsState()
    val onLogOutConfirm: () -> Unit = {
        authManager.signOut()
        navController.navigate(AppScreens.loginScreen.route)
    }
    val colorSelected = userStateVM.state.collectAsState().value.indexColor
    val isDarkSelect = userStateVM.state.collectAsState().value.isDarkMode
    var indexColor by rememberSaveable { mutableIntStateOf(colorSelected) }
    var isDarkMode by rememberSaveable { mutableStateOf(isDarkSelect) }

    LaunchedEffect(indexColor) {
        userStateVM.saveIndexColor(indexColor)
    }

    ExitSessionView(
        showDialog = exitSession,
        exit = onLogOutConfirm,
        onDismiss = { exitSession = false }
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        item {
            ProfileView(authManager, userStateVM, onClick = { exitSession = true })
        }
        item { TextAbel(text = "Selecciona un color de fondo",  size = 23.sp) }
        item { SpaceH(size = 7.dp) }
        item { ThemeSwitch(isDarkMode = isDarkMode, onClick = { isDarkMode = !isDarkMode })  }
        if(!isDarkMode) {
            item { bodyMedium(
                text = "Modo Light",
                modifier = Modifier
            ) }
            item { SpaceH() }
            item {
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    itemsIndexed(state.listColorsLight.take(3)) { index, colors ->
                        BoxItems(colors = colors, clickable = { indexColor = index })
                    }
                }
            }
        }
        else {
            item { bodyMedium(
                text = "Modo Dark",
                modifier = Modifier
            ) }
            item {
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    itemsIndexed(state.listColorsLight.takeLast(3)) { index, colors ->
                        BoxItems(colors = colors, clickable = { indexColor = index + 3 })
                    }
                }
            }
        }
    }
}

@Composable
fun BoxItems(
    colors: Color,
    clickable: () -> Unit
) {
    SpaceW(7.dp)
    Box(
        modifier = Modifier
            .size(65.dp)
            .background(
                color = colors,
                shape = MaterialTheme.shapes.medium
            )
            .clickable { clickable() }
    )
    SpaceW(7.dp)
}