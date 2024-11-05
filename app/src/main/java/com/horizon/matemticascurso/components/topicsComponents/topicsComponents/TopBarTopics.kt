package com.horizon.matemticascurso.views.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SentimentNeutral
import androidx.compose.material.icons.filled.SentimentSatisfiedAlt
import androidx.compose.material.icons.filled.SentimentVeryDissatisfied
import androidx.compose.material.icons.filled.SentimentVerySatisfied
import androidx.compose.material.icons.sharp.Lightbulb
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.adsContainer.AdvertView
import com.horizon.matemticascurso.adsContainer.selectLevelTopic
import com.horizon.matemticascurso.data.Local.ConnectionStatus
import com.horizon.matemticascurso.vms.FavoriteVM
import com.horizon.matemticascurso.vms.FavoriteViewModel
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopBarTopics(
    navController: NavController,
    titleTopBar: String,
    topicVM: TopicVM,
    pageContent: @Composable() (PagerScope.(Int) -> Unit),
    pagerState: PagerState,
    repeatBoxes: Int,
    spaceByBoxes: Dp,
    showExample: () -> Unit,
    widthBoxes: Dp = 20.dp
) {
    // Llama a connectivityStatus y obtén el estado de la conexión
    val conected by com.horizon.matemticascurso.data.Local.connectivityStatus()
    val isConected = conected === ConnectionStatus.Available
    val returnHome = remember { mutableStateOf(false) }
    val state by topicVM.state.collectAsState()

    LaunchedEffect(state.lifes) {
        if (state.lifes == 0) {
            delay(1000)
            pagerState.animateScrollToPage(
                0,
                animationSpec = tween(
                    700,
                    easing = LinearEasing
                )
            )
            topicVM.newLives()
        }
    }

    selectLevelTopic(
        isOpen = returnHome.value,
        onDismissRequest = { returnHome.value = false },
        navController = navController,
        context = LocalContext.current
    )

    Scaffold(
        topBar = {
            TopAppBarExercise(
                repeatBoxes,
                spaceByBoxes,
                pagerState,
                onClick = { navController.navigate(AppScreens.homeScreenRoute.route) },
                onClickFav = {  },
                widthBoxes
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showExample() },
                containerColor = MaterialTheme.colorScheme.onBackground
                ) {
                Icon(
                    imageVector = Icons.Sharp.Lightbulb,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            AdvertView()
            SpaceH(size = 7.dp)
            if (isConected) {
                horizontalStyle(
                    pageContent,
                    pagerState,
                    topicVM
                )
            }
            else {
                UnavailableScreen()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun horizontalStyle(
    pageContent: @Composable() (PagerScope.(Int) -> Unit),
    pagerState: PagerState,
    topicVM: TopicVM
) {

    val fillMaxWidth = Modifier.fillMaxWidth()
    val state by topicVM.state.collectAsState()

    Column{
        Box(
            modifier = fillMaxWidth.padding(horizontal = 5.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                modifier = fillMaxWidth,
                horizontalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val animatedIcon = when(state.lifes) {
                    3 -> Icons.Default.SentimentVerySatisfied
                    2 -> Icons.Default.SentimentNeutral
                    1 -> Icons.Default.SentimentVeryDissatisfied
                    else -> Icons.Default.SentimentSatisfiedAlt
                }
                repeat(state.lifes) {
                    Icon(
                        imageVector = animatedIcon,
                        contentDescription = "lifes user",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(all = 20.dp),
            userScrollEnabled = true,
            pageContent = pageContent
        )
    }
}