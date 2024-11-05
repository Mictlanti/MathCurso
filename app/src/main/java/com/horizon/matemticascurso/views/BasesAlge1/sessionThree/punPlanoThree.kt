@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionThree

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.OutlinedText
import com.horizon.matemticascurso.views.components.ScreenEnabled
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PuntosPlanoThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 1 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()

    analyticsTrackScreen(name = "puntos plano sesion 3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Puntos de plano",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> ScreenEnabled(modifier)
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 55.dp,
        showExample = { showExample.value = true }
    )
}

/*@Composable
fun LazyExercisepunPlaThree1(
    modifier: Modifier,
    pagerState: PagerState,
) {
    LazyColumn(modifier = modifier) {
        item { ExercisepunPlaThree1(pagerState, nextPage, ViewModel) }
    }
}

@Composable
private fun ExercisepunPlaThree1(
    pagerState: PagerState,
    context: Context = LocalContext.current
) {

    val state by ViewModel.state.collectAsState()
    val ifIncorrect = remember { mutableStateOf(false) }
    val ifCorrect = remember { mutableStateOf(false) }
    val listAnswerOne = listOf("A) x = -3     y = ", "B) x = 0     y = ", "C) x = 3     y = ")
    val recycleModi = Modifier.fillMaxWidth()
    val scope = rememberCoroutineScope()
    fun scroll() {
        if (state.textFieldOne == "-3" && state.textFieldTwo == "3" && state.textFieldThree == "9") {
            ifCorrect.value = true
            scope.launch {
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
            }
            ViewModel.onUserInput()
        } else if (state.textFieldOne.isEmpty() || state.textFieldTwo.isEmpty() || state.textFieldThree.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            ifIncorrect.value = true
        }
    }
    LaunchedEffect(key1 = ifIncorrect.value) {
        if (ifIncorrect.value) {
            delay(1200)
            ifIncorrect.value = false
            ViewModel.onUserInput()
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box4B3_one), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box4B3_two), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = recycleModi) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                listAnswerOne.forEachIndexed { index, s ->
                    Row(
                        modifier = recycleModi,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        bodyLarge(text = s, modifier = Modifier)
                        OutlinedText(
                            value = when (index) {
                                0 -> state.textFieldOne
                                1 -> state.textFieldTwo
                                2 -> state.textFieldThree
                                else -> state.textFieldOne
                            },
                            onValueChange = {
                                when (index) {
                                    0 -> ViewModel.updateTextField(firstText = it)
                                    1 -> ViewModel.updateTextFieldTwo(secondText = it)
                                    2 -> ViewModel.updateTextFieldThree(thirdText = it)
                                }
                            },
                            placeholder = null
                        )
                    }
                }
            }
        }
        BtnCheck(
            onClick = { scroll() },
            ifCorrect = ifCorrect.value,
            ifIncorrect = ifIncorrect.value
        )
    }
}*/
