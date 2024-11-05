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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
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
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.alertBtnStyle
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.components.topicsComponents.examplesToExercise.eToSistemEcuaOneSession1
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SistemEcua1OneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 8 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "sistema ecuaciones 1 sesion1", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Sistema de ecuaciones",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExampleSistemEcua1One1(modifier, pagerState, nextPage, userStateVM)
                1 -> LazyExampleSistemEcua1One2(modifier, pagerState, nextPage, userStateVM)
                2 -> LazyExerciseSistemEcua1One1(pagerState, modifier, topicVM, scope, userStateVM)
                3 -> LazyExerciseSistemEcua1One2(pagerState, modifier, topicVM, scope)
                4 -> LazyExerciseSistemEcua1One3(pagerState, modifier, topicVM, scope)
                5 -> LazyExerciseSistemEcua1One4(pagerState, modifier, topicVM, scope, userStateVM)
                6 -> LazyExerciseSistemEcua1One5(pagerState, modifier, topicVM, scope, userStateVM)
                7 -> LazyExerciseSistemEcua1One6(modifier, navController, topicVM, userStateVM)
            }
        },
        pagerState,
        repeatBoxes = 8,
        spaceByBoxes = 25.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExampleSistemEcua1One1(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExampleSistemEcua1One1(pagerState, nextPage, userStateVM) }
    }
}

@Composable
fun ExampleSistemEcua1One1(pagerState: PagerState, nextPage: Int, userStateVM: UserStateVM) {
    val scope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {
        SpaceH()
        bodyMedium(text = stringResource(id = R.string.Box1C1_one), modifier = Modifier)
        SpaceH()
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_sistemecuaone_one_dark,
            painterL = R.drawable.ejem_sistemecuaone_one_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        bodyMedium(text = stringResource(id = R.string.Box1C1_two), modifier = Modifier)
        Spacer(modifier = Modifier.height(15.dp))
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
fun LazyExampleSistemEcua1One2(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExampleSistemEcua1One2(pagerState, nextPage, userStateVM) }
    }
}

@Composable
fun ExampleSistemEcua1One2(pagerState: PagerState, nextPage: Int, userStateVM: UserStateVM) {
    val scope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.Box2C1_one))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_sistemecuaone_two_dark,
            painterL = R.drawable.ejem_sistemecuaone_two_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
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
private fun LazyExerciseSistemEcua1One1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1One1(pagerState, topicVM, scope, userStateVM) }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExerciseSistemEcua1One1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("5x+3y= 11", "2x - 3y = -4")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.pasoOne), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.img_paso_one_method_eli_dark,
            painterL = R.drawable.img_paso_one_method_eli_light,
            modifier = Modifier
        )
        HorizontalDivider()
        bodyMedium(text = stringResource(id = R.string.pasoOne_One), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_one_dark,
            painterL = R.drawable.ejer_sistemecuaone_one_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua1One2(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1One2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseSistemEcua1One2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("3x+6y= 15", "7x = 7")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.pasoTwo), modifier = Modifier)
        HorizontalDivider(modifier = recycleModi)
        bodyMedium(text = stringResource(id = R.string.pasoTwo_One), modifier = Modifier)
        SpaceH()
        bodyLarge(text = stringResource(id = R.string.pasoTwo_two), modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(end = 20.dp)
        )
        bodyLarge(
            text = "(5x + 3y) + (2x - 3y) = 11 - 4",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row {
            listOne.forEachIndexed { index, s ->
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
fun LazyExerciseSistemEcua1One3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1One3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseSistemEcua1One3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("x = 1", "x = 0")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.pasoThree), modifier = Modifier)
        HorizontalDivider(modifier = recycleModi)
        bodyMedium(text = stringResource(id = R.string.pasoThree_One), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "7x + 0 = 7", modifier = Modifier.align(Alignment.CenterHorizontally))
        SpaceH()
        Row {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua1One4(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1One4(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1One4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("y = 2", "y = 6")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.pasoFour), modifier = Modifier)
        HorizontalDivider(modifier = recycleModi)
        bodyMedium(text = stringResource(id = R.string.pasoFour_One), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_one_three_dark,
            painterL = R.drawable.ejer_sistemecuaone_one_three_light,
            modifier = Modifier
        )
        Row {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua1One5(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1One5(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1One5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("(x,y) = (1,6)", "(x,y) = (1,2)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.pasoFive), modifier = Modifier)
        HorizontalDivider(modifier = recycleModi)
        bodyMedium(text = stringResource(id = R.string.pasoFive_One), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_one_four_dark,
            painterL = R.drawable.ejer_sistemecuaone_one_four_light,
            modifier = Modifier
        )
        Row {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua1One6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1One6(navController, topicVM, userStateVM) }
    }
}

@Composable
fun ExerciseSistemEcua1One6(navController: NavController, topicVM: TopicVM, userStateVM: UserStateVM) {

    val listOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_two_dark,
            painterL = R.drawable.ejer_sistemecuaone_two_light,
            modifier = Modifier
        )
        Row(modifier = recycleModi) {
            listOne.forEachIndexed { index, s ->
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
            destination = AppScreens.sistemEcua1Two
        )
    }
}