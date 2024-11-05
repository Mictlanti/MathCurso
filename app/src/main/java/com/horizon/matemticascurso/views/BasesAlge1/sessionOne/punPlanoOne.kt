@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionOne

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PuntosPlanoOneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 7 })
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "Puntos de plano sesion 1", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Puntos del plano",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExercisepunPlaOne1(
                    modifier, pagerState,
                    topicVM,
                    scope
                )

                1 -> LazyExercisepunPlaOne2(
                    modifier, pagerState,
                    topicVM,
                    scope
                )

                2 -> LazyExercisepunPlaOne3(
                    modifier, pagerState,
                    topicVM,
                    scope
                )

                3 -> LazyExamplepunPlaOne1(
                    modifier,
                    pagerState,
                    nextPage
                )

                4 -> LazyExercisePunPlaOne4(
                    pagerState, modifier,
                    topicVM,
                    scope
                )

                5 -> LazyExercisePunPlaOne5(
                    pagerState, modifier,
                    topicVM,
                    scope
                )

                6 -> LazyExercisePunPlaOne6(
                    modifier, navController,
                    topicVM,
                )
            }
        },
        pagerState,
        repeatBoxes = 7,
        spaceByBoxes = 20.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExercisepunPlaOne1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExercisepunPlaOne1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExercisepunPlaOne1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne =
        listOf(stringResource(id = R.string.Mapa), stringResource(id = R.string.simbolos))
    val listAnswerTwo =
        listOf(stringResource(id = R.string.coordenadas), stringResource(id = R.string.ninguna))
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.ExercisepunPlaOne1_one), modifier = Modifier)
        Grafics(painterR = R.drawable.ejem_punpla_one_unit)
        bodyLarge(text = stringResource(id = R.string.ExercisepunPlaOne1_two), modifier = Modifier)
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyMedium(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = recycleModi) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyMedium(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExercisepunPlaOne2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExercisepunPlaOne2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExercisepunPlaOne2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne =
        listOf(stringResource(id = R.string.horizontal), stringResource(id = R.string.vertical))
    val listAnswerTwo =
        listOf(stringResource(id = R.string.inclinada), stringResource(id = R.string.ninguna))
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(
            text = stringResource(id = R.string.ExercisepunPlaOne1_three),
            modifier = Modifier
        )
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
        Row(modifier = recycleModi) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExercisepunPlaOne3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExercisepunPlaOne3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExercisepunPlaOne3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("(ac)(ab)", "(a + b)")
    val listAnswerTwo = listOf("(32)", "(3,2)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.ExercisepunPlaOne3_one), modifier = Modifier)
        Grafics(painterR = R.drawable.ejem_punpla_one_unit)
        bodyLarge(text = stringResource(id = R.string.ExercisepunPlaOne3_two), modifier = Modifier)
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = recycleModi) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExamplepunPlaOne1(modifier: Modifier, pagerState: PagerState, nextPage: Int) {
    LazyColumn(modifier = modifier) {
        item { ExamplepunPlaOne1(pagerState, nextPage) }
    }
}

@Composable
private fun ExamplepunPlaOne1(pagerState: PagerState, nextPage: Int) {
    val scope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        bodyLarge(text = stringResource(id = R.string.Box2B3_two), modifier = Modifier)
        bodyLarge(
            text = "A) (2,3)\nB) (-2-1)\nC) (-3,2)\nD) (3,-2)",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Grafics(
            painterR = R.drawable.ejem_punpla_two_unit,
            modifier = Modifier
                .size(width = 300.dp, height = 330.dp)
                .padding(10.dp)
        )
        SpaceH(size = 10.dp)
        bodyMedium(text = stringResource(id = R.string.ExamplePunPlaOne_one), modifier = Modifier)
        btnExample(onClick = {
            scope.launch {
                pagerState.animateScrollToPage(
                    nextPage,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
            }
        })
    }
}

@Composable
fun LazyExercisePunPlaOne4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExercisePunPlaOne4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExercisePunPlaOne4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("(3, 2)", "(3, 0)")
    val listAnswerTwo = listOf("(0, -3)", "(2, 3)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box3B3_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        Grafics(
            painterR = R.drawable.ejer_punpla_one_unit,
            modifier = Modifier
                .size(width = 300.dp, height = 320.dp)
                .padding(10.dp)
        )
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = recycleModi) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExercisePunPlaOne5(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExercisePunPlaOne5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExercisePunPlaOne5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listAnswerOne = listOf("(2, 1)", "(1, 0)")
    val listAnswerTwo = listOf("(0, 4)", "(3, -2)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.ExercisePunPlaOne_five), modifier = Modifier)
        SpaceH(size = 10.dp)
        Grafics(
            painterR = R.drawable.ejer_punpla_one_unit,
            modifier = Modifier
                .size(width = 300.dp, height = 320.dp)
                .padding(10.dp)
        )
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = recycleModi) {
            listAnswerTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExercisePunPlaOne6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExercisePunPlaOne6(navController = navController, topicVM) }
    }
}

@Composable
private fun ExercisePunPlaOne6(navController: NavController, topicVM: TopicVM) {

    val listAnswerOne = listOf("(- 1/2, 3)", "(-1, -3)")
    val listAnswerTwo = listOf("(3, 0)", "(0, 3)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.ExercisePunPlaOne_six), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        Grafics(
            painterR = R.drawable.ejer_punpla_one_unit,
            modifier = Modifier
                .size(width = 300.dp, height = 320.dp)
                .padding(10.dp)
        )
        Row(modifier = recycleModi) {
            listAnswerOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = recycleModi) {
            listAnswerTwo.forEachIndexed { index, s ->
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
            destination = AppScreens.punPlanoTwo
        )
    }
}