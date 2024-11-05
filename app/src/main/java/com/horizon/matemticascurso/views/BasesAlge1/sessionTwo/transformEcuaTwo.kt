@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionTwo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.ScreenEnabled
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM

@Composable
fun transforEcuaTwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 1 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()

    analyticsTrackScreen(name = "transformacion de ecuaciones", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Transformación",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> ScreenEnabled(modifier = modifier)
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 50.dp,
        showExample = { showExample.value = true }
    )
}