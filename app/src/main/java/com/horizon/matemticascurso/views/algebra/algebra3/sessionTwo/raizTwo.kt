package com.horizon.matemticascurso.views.algebra.algebra3.sessionTwo

import android.annotation.SuppressLint
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
import com.horizon.matemticascurso.views.components.UnavailableScreen
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun raizTwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 1 })
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val showExample = remember { mutableStateOf(false) }

    analyticsTrackScreen(name = "raiz_two", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Raiz",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> UnavailableScreen()
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 50.dp,
        showExample = { showExample.value = true }
    )
}