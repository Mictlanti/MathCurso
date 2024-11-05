@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessioThree

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Facto1ThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 5 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "factorizacion 1 sesion 3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Factorización",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseFacto1Three1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseFacto1Three2(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseFacto1Three3(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseFacto1Three4(modifier, pagerState, topicVM, scope)
                4 -> LazyExerciseFacto1Three5(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 30.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseFacto1Three1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto1Three1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto1Three1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x(1 - a)", "x(x + 1)")
    val listTwo = listOf("a(x - 1)", "x(a - 1)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }


    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        bodyLarge(text = "x - xa =", modifier = align)
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto1Three2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto1Three2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto1Three2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("a(x+y)(bc+xy)", "ax(x+y)(9c+9y)")
    val listTwo = listOf("a(x+y)(9c+xy)", "9a(x+y)(bc-xy)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        bodyLarge(text = "9abc(x + y) - 9axy(x + y) =", modifier = align)
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyMedium(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyMedium(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto1Three3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto1Three3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto1Three3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("(x + y)", "-(x - y)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "-x",
            exponenOne = "2",
            next = " + 2xy - ",
            baseTwo = "y",
            exponenTwo = "2"
        )
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    Exponente(base = s, exponente = "2", modifier = Modifier)
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto1Three4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto1Three4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto1Three4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("4ab(3x + 2y)", "(6bx + 3ay)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        Spacer(modifier = Modifier.height(10.dp))
        ExponenteCuadrado(
            baseOne = "36abx",
            exponenOne = "2",
            next = "48abx",
            baseTwo = "16aby",
            exponenTwo = "2"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { Exponente(base = s, exponente = "2", modifier = Modifier, fontSize = 22.sp) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto1Three5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto1Three5(navController,  topicVM) }
    }
}

@Composable
private fun ExerciseFacto1Three5(navController: NavController, topicVM: TopicVM) {

    val listOne = listOf("2a(x-2)(3a-2)", "(x-2)(3a-1)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "6a",
            exponenOne = "2",
            next = "(x - 2) - 4a",
            baseTwo = "(x - 2) = ",
            exponenTwo = ""
        )
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyMedium(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.facto2One
        )
    }
}