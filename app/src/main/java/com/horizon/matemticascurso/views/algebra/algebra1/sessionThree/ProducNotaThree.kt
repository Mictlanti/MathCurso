@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionThree

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.By
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.ui.theme.Color1
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.FormulaProductoNotable
import com.horizon.matemticascurso.views.components.FormulaProductoNotableTwo
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProducNotaThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 5 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "productos notables sesion3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Porductos notables",
        topicVM,
        pageContent = { page ->
            AnimatedVisibility(
                visible = page == pagerState.currentPage,
                enter = scaleIn(animationSpec = tween(1000)),
                exit = scaleOut(animationSpec = tween(1000))
            ) {
                when (page) {
                    0 -> LazyExerciseProducNotaThree1(
                        modifier,
                        pagerState,
                        scope,
                        topicVM
                    )

                    1 -> LazyExerciseProducNotaThree2(
                        modifier,
                        pagerState,
                        scope,
                        topicVM
                    )

                    2 -> LazyExerciseProducNotaThree3(
                        modifier,
                        pagerState,
                        scope,
                        topicVM
                    )

                    3 -> LazyExerciseProducNotaThree4(
                        modifier,
                        pagerState,
                        scope,
                        topicVM
                    )

                    4 -> LazyExerciseProducNotaThree5(modifier, navController, topicVM)
                }
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 25.dp,
        showExample = { showExample.value = true },
        widthBoxes = 35.dp
    )
}

@Composable
fun LazyExerciseProducNotaThree1(
    modifier: Modifier,
    pagerState: PagerState,
    scope: CoroutineScope,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaThree1(pagerState, scope, topicVM) }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExerciseProducNotaThree1(
    pagerState: PagerState,
    scope: CoroutineScope,
    topicVM: TopicVM
) {

    val listOne = listOf(" - 6x - ", " + 6x +")
    val listTwo = listOf(" + 5x + ", " - 5x +")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormulaProductoNotable()
        titleMedium(text = stringResource(id = R.string.desarrollo))
        bodyLarge(text = "(x + 2)(x + 4) = ", modifier = Modifier)
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            Exponente(base = "x", exponente = "2", modifier = Modifier)
            bodyLarge(text = " + (2 + 4)x + 2", modifier = Modifier)
            By()
            bodyLarge(text = "4", modifier = Modifier)
        }
        ExponenteCuadrado(
            baseOne = "x",
            exponenOne = "2",
            next = " + 6x + ",
            baseTwo = "8",
            exponenTwo = ""
        )
        bodyLarge(text = stringResource(id = R.string.Box7C4_Desa), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        bodyLarge(
            text = "(x + 3)(x + 2) = ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "5",
                        exponenTwo = ""
                    )
                }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "6",
                        exponenTwo = ""
                    )
                }
            }
        }
        BtnCheck(onClick = { check() }, topicVM)
    }
}

@Composable
fun LazyExerciseProducNotaThree2(
    modifier: Modifier,
    pagerState: PagerState,
    scope: CoroutineScope,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaThree2(pagerState, scope, topicVM) }
    }
}

@Composable
private fun ExerciseProducNotaThree2(
    pagerState: PagerState,
    scope: CoroutineScope,
    topicVM: TopicVM
) {

    val listOne = listOf(" - 3x + ", " - 2x + ")
    val listTwo = listOf(" - 3x - ", " - 4x +")
    val modifier = Modifier.fillMaxWidth()

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box7C4_Desa), modifier = Modifier)
        SpaceH()
        bodyLarge(
            text = "(x - 2)(x - 1) = ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "2",
                        exponenTwo = ""
                    )
                }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "2",
                        exponenTwo = ""
                    )
                }
            }
        }
        BtnCheck(onClick = { topicVM.checkInt(scope, pagerState, indexCorrect = 1) }, topicVM)
    }
}

@Composable
fun LazyExerciseProducNotaThree3(
    modifier: Modifier,
    pagerState: PagerState,
    scope: CoroutineScope,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaThree3(pagerState, scope, topicVM) }
    }
}

@Composable
private fun ExerciseProducNotaThree3(
    pagerState: PagerState,
    scope: CoroutineScope,
    topicVM: TopicVM
) {

    val listOne = listOf(" - 5x + ", " + 7x + ")
    val listTwo = listOf(" + 7x + ", " + 6x +")
    val modifier = Modifier.fillMaxWidth()

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        FormulaProductoNotableTwo()
        bodyLarge(
            text = stringResource(id = R.string.Box1C4Notables_apliformu),
            modifier = Modifier
        )
        SpaceH()
        bodyLarge(
            text = "(2x + 1)(x + 3) = ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "2x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "3",
                        exponenTwo = "",
                        fontSize = 22.sp
                    )
                }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = if (index == 0) "x" else "2x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "3",
                        exponenTwo = "",
                        fontSize = 22.sp
                    )
                }
            }
        }
        BtnCheck(onClick = { topicVM.checkInt(scope, pagerState, 2) }, topicVM)
    }
}

@Composable
fun LazyExerciseProducNotaThree4(
    modifier: Modifier,
    pagerState: PagerState,
    scope: CoroutineScope,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaThree4(pagerState, scope, topicVM) }
    }
}

@Composable
private fun ExerciseProducNotaThree4(
    pagerState: PagerState,
    scope: CoroutineScope,
    topicVM: TopicVM
) {

    val listOne = listOf(" + 12x + ", " + 21x - ")
    val listTwo = listOf(" + 9x -", " + 9x - ")
    val modifier = Modifier.fillMaxWidth()

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box7C4_Desa), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "(2x + 5)(3x - 3)", modifier = Modifier.align(Alignment.CenterHorizontally))
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "6x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "15",
                        exponenTwo = "",
                        fontSize = 18.sp
                    )
                }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = if (index == 0) "x" else "6x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "15",
                        exponenTwo = "",
                        fontSize = 20.sp
                    )
                }
            }
        }
        BtnCheck(onClick = { topicVM.checkInt(scope, pagerState, 4) }, topicVM)
    }
}

@Composable
fun LazyExerciseProducNotaThree5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseProducNotaThree5(navController, topicVM) }
    }
}

@Composable
private fun ExerciseProducNotaThree5(
    navController: NavController,
    topicVM: TopicVM
) {

    val listOne = listOf(" - 31xy - ", " - 31xy + ")
    val listTwo = listOf(" + 30xy -", " + 16xy - ")
    val modifier = Modifier.fillMaxWidth()

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box7C4_Desa), modifier = Modifier)
        SpaceH()
        bodyLarge(
            text = "(-x - 5y)(6x + y) = ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = modifier.weight(1f),
                    topicVM = topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = "-6x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "5y",
                        exponenTwo = "2",
                        fontSize = 18.sp
                    )
                }
            }
        }
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 3,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteCuadrado(
                        baseOne = if (index == 0) "-x" else "6x",
                        exponenOne = "2",
                        next = s,
                        baseTwo = "5y",
                        exponenTwo = "2",
                        fontSize = 18.sp
                    )
                }
            }
        }
        btnNextTopic(
            onClick = { topicVM.checkFinishInt(1) },
            topicVM,
            navController,
            destination = AppScreens.facto1One
        )
    }
}