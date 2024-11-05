@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionTwo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
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
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SpecialExponenteCuadrado
import com.horizon.matemticascurso.views.algebra.algebra1.sessionThree.listError
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.CuadradoPerfectoNegativo
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Facto1TwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 5 })
    val showExample = remember { mutableStateOf(false) }
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "factorizacion 1 sesion2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Factorización",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseFacto1Two1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseFacto1Two2(
                    modifier,
                    pagerState, topicVM, scope
                )

                2 -> LazyExerciseFacto1Two3(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseFacto1Two4(modifier, pagerState, topicVM, scope)
                4 -> LazyExerciseFacto1Two5(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 45.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseFacto1Two1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto1Two1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto1Two1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("(x+y)(a+b)", "3(x+y)(2a-b)")
    val listTwo = listOf("ab(x+y)", "2(x+y)(3a+b)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.Box2D1_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        bodyLarge(
            text = "6a(x + y) + 2b(x + y) =",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
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
                    modifier = when (index) {
                        0 -> modifier.weight(1f)
                        1 -> modifier.weight(2f)
                        else -> modifier.weight(1f)
                    },
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
fun LazyExerciseFacto1Two2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseFacto1Two2(
                pagerState,
                topicVM, scope
            )
        }
    }
}

@Composable
private fun ExerciseFacto1Two2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        if (state.onValueChange == "x(x-y)(x-1)" || state.onValueChange == "x(x-1)(x-y)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, listError.random(), Toast.LENGTH_LONG).show()
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.Box2D1_one), modifier = Modifier)
        SpaceH()
        ExponenteCuadrado(
            baseOne = "x",
            exponenOne = "2",
            next = "(x - y) - x",
            baseTwo = "(x - y) = ",
            exponenTwo = ""
        )
        SpaceH()
        HorizontalDivider()
        if (state.onValueChange.isEmpty()) {
            bodyMedium(text = stringResource(id = R.string.factoOne_two_one), modifier = Modifier)
            bodyMedium(text = "Ej. az(b+c)(x+y)", modifier = align)
        } else {
            bodyLarge(text = state.onValueChange, modifier = align)
        }
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(it) },
            keyboardType = KeyboardType.Text,
            placeholder = null
        )
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto1Two3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto1Two3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto1Two3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("(x - 3y)", "(3x - y)")
    val listTwo = listOf("(x - 2)(x - 3)", "3(x - 3)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        CuadradoPerfectoNegativo()
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "x",
            exponenOne = "2",
            next = " - 6xy + ",
            baseTwo = "9y",
            exponenTwo = "2"
        )
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) { Exponente(base = s, exponente = "2", modifier = Modifier) }
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
fun LazyExerciseFacto1Two4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto1Two4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto1Two4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("(x - 5)", "x(x + 5)")
    val listTwo = listOf("x(x + 5)", "x(x - 1)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ExponenteCuadrado(
            baseOne = "ax",
            exponenOne = "2",
            next = " - 4axy + ",
            baseTwo = "4ay",
            exponenTwo = "2"
        )
        Row(horizontalArrangement = Arrangement.Center, modifier = modifier) {
            ExponenteCuadrado(
                baseOne = " = a(x",
                exponenOne = "2",
                next = " - 4xy + ",
                baseTwo = "4y",
                exponenTwo = "2"
            )
            bodyLarge(text = ")", modifier = Modifier)
        }
        Exponente(
            base = " = a(x - 2y)",
            exponente = "2",
            modifier = align
        )
        HorizontalDivider()
        bodyLarge(text = stringResource(id = R.string.Box2D1_one), modifier = Modifier)
        SpaceH()
        SpecialExponenteCuadrado(
            baseOne = "x",
            exponenOne = "3",
            baseNext = " + 10x",
            exponenteNext = "2",
            baseTwo = " + 25x",
            exponenTwo = ""
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
fun LazyExerciseFacto1Two5(
    modifier: Modifier,
    navControlller: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto1Two5(navControlller, topicVM) }
    }
}

@Composable
private fun ExerciseFacto1Two5(navController: NavController, topicVM: TopicVM) {

    val listOne = listOf("x(x - a)", "(x - a)")
    val listTwo = listOf("(x - a)", "x(x - a)(x - 1)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "x",
            exponenOne = "2",
            next = "(x - a) - x(x - a)",
            baseTwo = " = ",
            exponenTwo = ""
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
        Row(modifier = modifier) {
            listTwo.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = when (index) {
                        0 -> modifier.weight(1f)
                        1 -> modifier.weight(2f)
                        else -> modifier.weight(1f)
                    },
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.facto1Three
        )
    }
}