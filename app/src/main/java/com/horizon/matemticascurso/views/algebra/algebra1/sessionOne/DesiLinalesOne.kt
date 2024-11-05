@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionOne

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
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
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DesigualLinealOneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 6 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "desigualdades lineales sesion1", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Desigualdades lineales",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExampleDesiLinealOne1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseDesiLinealOne1(pagerState, modifier, topicVM, scope)
                2 -> LazyExerciseDesiLinealOne2(pagerState, modifier, topicVM, scope)
                3 -> LazyExerciseDesiLinealOne3(pagerState, modifier, topicVM, scope)
                4 -> LazyExerciseDesiLinealOne4(pagerState, modifier, topicVM, scope)
                5 -> LazyExerciseDesiLinealOne5(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 25.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExampleDesiLinealOne1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExampleDesiLinealOne1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExampleDesiLinealOne1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listS = listOf(
        stringResource(id = R.string.ExampleDesiOne_one),
        stringResource(id = R.string.ExampleDesiOne_two)
    )
    val listOne = listOf("x mayor que 5", "x menor que 5")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.Box1Desi_one), modifier = Modifier)
        listS.forEach { s ->
            bodyLarge(text = s, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
        forBodyorExercise(body = stringResource(id = R.string.Box1Desi_three))
        Divider(modifier = recycleModi)
        bodyLarge(text = stringResource(id = R.string.ExampleDesiOne_three), modifier = Modifier)
        bodyLarge(text = "x > 5", modifier = Modifier.align(Alignment.CenterHorizontally))
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
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
fun LazyExerciseDesiLinealOne1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealOne1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseDesiLinealOne1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x > 11", "x < 1")
    val listTwo = listOf("x > 1", "x < 11")
    val listAns = listOf("7x - 8 < 6", "Sol. 7x < 8 + 6", "7< < 14", "x < 2")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.sumDesiLineales), modifier = Modifier)
        titleMedium(text = stringResource(id = R.string.desarrollo))
        listAns.forEach { s ->
            bodyLarge(text = s, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
        bodyMedium(text = stringResource(id = R.string.sumDesiLineales_one), modifier = Modifier)
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        bodyLarge(text = "x - 5 < 6", modifier = align)
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
                    index + 1,
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
fun LazyExerciseDesiLinealOne2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealOne2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseDesiLinealOne2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x > 6", "x < 2")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.sumDesiLineales), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.sumDesiLineales_one), modifier = Modifier)
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "2x > x + 6", modifier = align)
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
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
fun LazyExerciseDesiLinealOne3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealOne3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseDesiLinealOne3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x > 18", "x > 12")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.sumDesiLineales), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.sumDesiLineales_one), modifier = Modifier)
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "2x + 3 > 15", modifier = align)
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
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
fun LazyExerciseDesiLinealOne4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealOne4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseDesiLinealOne4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x > 1", "x < 1")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.sumDesiLineales), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.sumDesiLineales_one), modifier = Modifier)
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "4x > 2x + 2", modifier = align)
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
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
fun LazyExerciseDesiLinealOne5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseDesiLinealOne5(navController, topicVM) }
    }
}

@Composable
private fun ExerciseDesiLinealOne5(navController: NavController, topicVM: TopicVM) {

    val listOne = listOf("x > 2", "x < 2")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.sumDesiLineales), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.sumDesiLineales_one), modifier = Modifier)
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "5x - 4 < 3x", modifier = align)
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1 ,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.desigualLinealesTwo
        )
    }
}