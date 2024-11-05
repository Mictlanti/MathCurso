@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionThree

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GraficaRectaThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 4 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "grafica recta session 3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Gráfica de la recta",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseGrafiRectaThree1(pagerState, modifier, topicVM, scope)
                1 -> LazyExerciseGrafiRectaThree2(pagerState, modifier, topicVM, scope)
                2 -> LazyExerciseGrafiRectaThree3(pagerState, modifier, topicVM, scope)
                3 -> LazyExerciseGrafiRectaThree4(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 4,
        spaceByBoxes = 48.dp,
        showExample = { showExample.value = true },
        widthBoxes = 30.dp
    )
}

@Composable
fun LazyExerciseGrafiRectaThree1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaThree1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseGrafiRectaThree1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("m = 2\nb = 1", "m = -2\nb = -1")
    val listTwo = listOf("m = 3\nb = 0", "m = 1\nb = 0")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        bodyLarge(text = stringResource(id = R.string.Box3B4_one), modifier = Modifier)
        Grafics(
            painterR = R.drawable.ejem_grarecone_five_unit,
            modifier = Modifier
                .size(width = 250.dp, height = 300.dp)
                .padding(10.dp)
        )
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaThree2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaThree2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseGrafiRectaThree2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf(
        painterResource(id = R.drawable.btn_grarecone_f_one_unit),
        painterResource(id = R.drawable.btn_grarecone_f_two_unit)
    )
    val listTwo = listOf(
        painterResource(id = R.drawable.btn_grarecone_v_unit),
        painterResource(id = R.drawable.btn_grarecone_f_three_unit)
    )
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.Box4B4_one), modifier = Modifier)
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { Image(painter = s, contentDescription = null) }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { Image(painter = s, contentDescription = null) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaThree3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaThree3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseGrafiRectaThree3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("A) 4 unidades\nB) m = 3\n  b = 1", "A) 2 unidades\nB) m = 1.5\n  b = -1")
    val listTwo = listOf("A) 3 unidades\nB) m = 3/2\n  b = -1", "A) 0 unidades\nB) m = 2\n  b = 0")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box5B4_one), modifier = Modifier)
        Grafics(painterR = R.drawable.ejer_grarecone_one_unit)
        bodyMedium(text = stringResource(id = R.string.Box5B4_two), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box5B4_three), modifier = Modifier)
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { bodyMedium(text = s, modifier = Modifier) }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { bodyMedium(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaThree4(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaThree4(navController, topicVM) }
    }
}

@Composable
private fun ExerciseGrafiRectaThree4(
    navController: NavController,
    topicVM: TopicVM
) {

    val listOne = listOf("Verdadero", "Falso")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        titleMedium(text = stringResource(id = R.string.VoF))
        bodyLarge(text = stringResource(id = R.string.Box7B4_one), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box7B4_two), modifier = Modifier)
        Grafics(painterR = R.drawable.ejer_grarecone_three_unit)
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.sitemaEcua1
        )
    }
}