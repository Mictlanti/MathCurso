@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.main

import android.content.SharedPreferences
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.horizon.matemticascurso.components.homeComponents.titleLargeHome
import com.horizon.matemticascurso.components.homeComponents.withoutInternet
import com.horizon.matemticascurso.data.Local.ConnectionStatus
import com.horizon.matemticascurso.data.firebase.AuthManager
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.SpaceW
import com.horizon.matemticascurso.views.components.SubjectCard
import com.horizon.matemticascurso.views.components.headLineSmallHome
import com.horizon.matemticascurso.views.components.horizontalScreen
import com.horizon.matemticascurso.vms.UserStateVM

fun saveSelectValue(sharedPreferences: SharedPreferences, value: Int) {
    with(sharedPreferences.edit()) {
        putInt("selected_page_key", value)
        apply()
    }
}

fun getSelectValue(sharedPreferences: SharedPreferences): Int {
    return sharedPreferences.getInt("selected_page_key", 0) // Valor predeterminado es 0
}

@Composable
fun HomeScreeRoute(
    navController: NavController,
    auth: AuthManager,
    realtimeManager: UserStateVM,
    sharedPreferences: SharedPreferences
) {
    Homescreen(navController, auth, realtimeManager, sharedPreferences)
}

@Composable
private fun Homescreen(
    navController: NavController,
    auth: AuthManager,
    userStateVM: UserStateVM,
    sharedPreferences: SharedPreferences
) {

    val profileOpen = remember { mutableStateOf(false) }

    ProfileScreenRoute(
        profile = profileOpen.value,
        onDissMiss = { profileOpen.value = false },
        authManager = auth,
        userStateVM = userStateVM,
        navController = navController
    )

    Scaffold(
        topBar = {
            titleLargeHome(
                authManager = auth,
                onClick = { profileOpen.value = true }
            ) },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        HomeScreen(
            paddingValues = paddingValues,
            navController = navController,
            sharedPreferences
        )
    }
}

@Composable
private fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    sharedPreferences: SharedPreferences
) {

    val savedValue = remember { getSelectValue(sharedPreferences) }
    var selectedPage by rememberSaveable { mutableIntStateOf(savedValue) }
    val pagerState = rememberPagerState(pageCount = { 5 })
    var expanded by remember { mutableStateOf(false) }
    val fillMaxWith = Modifier.fillMaxWidth()
    val fillMaxSize = Modifier.fillMaxSize()
    val conected by com.horizon.matemticascurso.data.Local.connectivityStatus()
    val isConected = conected === ConnectionStatus.Available

    LaunchedEffect(selectedPage) {
        pagerState.animateScrollToPage(
            selectedPage,
            animationSpec = tween(
                durationMillis = 700,
                easing = EaseIn
            )
        )
        saveSelectValue(sharedPreferences, selectedPage)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedPage = pagerState.currentPage
            saveSelectValue(sharedPreferences, selectedPage)
        }
    }

    LazyColumn(
        modifier = fillMaxSize
            .padding(paddingValues)
    ) {
        if (!isConected) {
            item {
                withoutInternet(
                    modifier = fillMaxWith.padding(horizontal = 25.dp, vertical = 10.dp),
                    text = "Falla en conexión"
                )
            }
        }
        item {
            Box(
                modifier = fillMaxWith
                    .animateContentSize()
                    .height(if (!expanded) 260.dp else 53.dp)
            ) {
                Column(modifier = fillMaxSize) {
                    Row(
                        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                        modifier = fillMaxWith
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                            .clickable { expanded = !expanded }
                    ) {
                        headLineSmallHome(title = stringResource(id = R.string.Sections))
                        Icon(
                            imageVector = if (!expanded) Icons.Default.ArrowDropDown else Icons.Default.ArrowDropUp,
                            contentDescription = null,
                            modifier = Modifier.size(38.dp)
                        )
                    }
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
                    ) {
                        val listSubjectCard = listOf("Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4")
                        item {
                            listSubjectCard.forEachIndexed { index, s ->
                                SpaceW()
                                SubjectCard(
                                    sectionsNumber = s,
                                    isSelected = selectedPage == index,
                                    onClick = { selectedPage = index },
                                    topics = when (index) {
                                        0 -> stringResource(id = R.string.basesAlge)
                                        1 -> stringResource(id = R.string.algebra1)
                                        2 -> stringResource(id = R.string.algebra2)
                                        3 -> stringResource(id = R.string.algebra3)
                                        else -> "temas"
                                    }
                                )
                                SpaceW(size = 10.dp)
                            }
                        }
                    }
                }
            }
        }
        item {
            SpaceH()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                headLineSmallHome(title = stringResource(id = R.string.selectTopic))
                IconButton(onClick = { navController.navigate(AppScreens.favoriteScreen.route) }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.Red,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
        item { SpaceH() }
        item {
            horizontalScreen(
                pagerState = pagerState,
                navController,
                modifier = fillMaxSize
                    .padding(horizontal = 5.dp)
            )
        }
    }
}