@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionTwo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Grafics
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedText
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.vms.TopicVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PuntosPlanoTwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 5 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "puntos plano sesion 2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Punto del plano",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExercisepunPlaTwo1(
                    modifier,
                    pagerState,
                    topicVM, scope
                )
                1 -> LazyExercisePunPlaTwo2(pagerState, modifier, topicVM, scope)
                2 -> LazyExercisePunPlaTwo3(pagerState, modifier, topicVM, scope)
                3 -> LazyExercisePunPlaTwo4(pagerState, modifier, topicVM, scope)
                4 -> LazyExercisePunPlaTwo5(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 35.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExercisepunPlaTwo1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExercisepunPlaTwo1(
                pagerState,
                topicVM,
                scope
            )
        }
    }
}

@Composable
private fun ExercisepunPlaTwo1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    val listAnswerOne =
        listOf(
            "A) x = -3     y = ${state.onValueChange}",
            "B) x = 0     y = ${state.onValueChangeTwo}",
            "C) x = 3     y = ${state.onValueChangeThree}"
        )
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "-3" && state.onValueChangeTwo == "3" && state.onValueChangeThree == "9") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty() || state.onValueChangeThree.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
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
                                0 -> state.onValueChange
                                1 -> state.onValueChangeTwo
                                2 -> state.onValueChangeThree
                                else -> state.onValueChange
                            },
                            onValueChange = {
                                when (index) {
                                    0 -> topicVM.onValueChangeOne(onValue = it)
                                    1 -> topicVM.onValueChangeTwo(onValue = it)
                                    2 -> topicVM.onValueChangeThree(onValue = it)
                                }
                            },
                            placeholder = null
                        )
                    }
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExercisePunPlaTwo2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExercisePunPlaTwo2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExercisePunPlaTwo2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("(3, 5)", "(3, 1)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box5B3_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        bodyMedium(text = stringResource(id = R.string.Box5B3_two), modifier = Modifier)
        bodyLarge(text = "x = 3", modifier = Modifier.align(Alignment.CenterHorizontally))
        SpaceH()
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExercisePunPlaTwo3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExercisePunPlaTwo3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExercisePunPlaTwo3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("(-1, -3)", "(-1, 1)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box5B3_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        bodyMedium(text = stringResource(id = R.string.Box5B3_two), modifier = Modifier)
        bodyLarge(text = "x = -1", modifier = Modifier.align(Alignment.CenterHorizontally))
        SpaceH()
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExercisePunPlaTwo4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExercisePunPlaTwo4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExercisePunPlaTwo4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("(-4, -2)", "(-4, -6)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box5B3_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        bodyMedium(text = stringResource(id = R.string.ExercisepunPlaTwo_one), modifier = Modifier)
        SpaceH()
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExercisePunPlaTwo5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExercisePunPlaTwo5(navController, topicVM) }
    }
}

@Composable
private fun ExercisePunPlaTwo5(navController: NavController, topicVM: TopicVM) {

    val listAnswerOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        Spacer(modifier = Modifier.height(10.dp))
        bodyMedium(text = stringResource(id = R.string.ExercisepunPlaTwo_two), modifier = Modifier)
        Grafics(painterR = R.drawable.ejer_punplatwo_one, modifier = Modifier.align(Alignment.CenterHorizontally).padding(10.dp))
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.punPlaThree
        )
    }
}