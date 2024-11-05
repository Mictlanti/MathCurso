@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionOne

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.By
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteLarge
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.FormulaDiferenciaCuadrados
import com.horizon.matemticascurso.views.components.FormulaFactorizacionOne
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Facto2OneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 7 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "factorizacion 2 sesion1", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Factorización",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseFacto2One1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseFacto2One2(
                    modifier,
                    pagerState,
                    topicVM,
                    scope
                )

                2 -> LazyExerciseFacto2One3(
                    modifier,
                    pagerState,
                    topicVM,
                    scope
                )

                3 -> LazyExerciseFacto2One4(modifier, pagerState, topicVM, scope)
                4 -> LazyExampleFacto2One1(modifier, pagerState, nextPage)
                5 -> LazyExerciseFacto2One5(
                    modifier,
                    pagerState,
                    topicVM,
                    scope,
                    userStateVM
                )
                6 -> LazyExerciseFacto2One6(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 7,
        spaceByBoxes = 17.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseFacto2One1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2One1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto2One1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("2(x + 2)", "(x - 2)(x - 2)")
    val listTwo = listOf("(x+2)(x-2)", "(x+2)(x+2)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        FormulaDiferenciaCuadrados()
        bodyLarge(
            text = stringResource(id = R.string.factoriza),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        ExponenteCuadrado(
            baseOne = "x",
            exponenOne = "2",
            next = " - ",
            baseTwo = "4",
            exponenTwo = ""
        )
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
fun LazyExerciseFacto2One2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseFacto2One2(
                pagerState,
                topicVM, scope
            )
        }
    }
}

@Composable
private fun ExerciseFacto2One2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    fun check() {
        if (state.onValueChange == "(2ab+5c)(2ab-5c)" || state.onValueChange == "(2ab-5c)(2ab+5c)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, listErrorTwo.random(), Toast.LENGTH_LONG).show()
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        FormulaDiferenciaCuadrados()
        bodyLarge(
            text = stringResource(id = R.string.factoriza),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        ExponenteLarge(
            b1 = "4a",
            b2 = "b",
            b3 = " - 25c",
            e1 = "2",
            e2 = "2",
            e3 = "2",
            modifier = Modifier
        )
        SpaceH()
        HorizontalDivider()
        if (state.onValueChange.isEmpty()) {
            bodyLarge(text = "Ej. (a+b)(a-b)", modifier = align)
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
fun LazyExerciseFacto2One3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseFacto2One3(
                pagerState,
                topicVM, scope
            )
        }
    }
}

@Composable
private fun ExerciseFacto2One3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun check() {
        if (state.onValueChange == "(ax+4y)(ax-4y)" || state.onValueChange == "(ax-4y)(ax+4y)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, listErrorTwo.random(), Toast.LENGTH_LONG).show()
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(
            text = stringResource(id = R.string.factoriza),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        ExponenteLarge(
            b1 = "a",
            b2 = "x",
            b3 = " - 16y",
            e1 = "2",
            e2 = "2",
            e3 = "2",
            modifier = Modifier
        )
        SpaceH()
        HorizontalDivider()
        if (state.onValueChange.isEmpty()) {
            bodyLarge(text = "Ej. (a+b)(a-b)", modifier = align)
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
fun LazyExerciseFacto2One4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2One4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto2One4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("y", "x")
    val listTwo = listOf("x(y-3)", "0")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(
            text = stringResource(id = R.string.factoriza),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        ExponenteLarge(
            b1 = "4x",
            b2 = "y",
            b3 = " - 9y",
            e1 = "2",
            e2 = "2",
            e3 = "2",
            modifier = Modifier
        )
        SpaceH()
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    ExponenteLarge(
                        b1 = s,
                        b2 = "(2x+3)",
                        b3 = "(2x-3)",
                        e1 = "",
                        e2 = "",
                        e3 = "",
                        modifier = Modifier
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
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExampleFacto2One1(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
) {
    LazyColumn(modifier = modifier) {
        item { ExampleFacto2One1(pagerState, nextPage) }
    }
}

@Composable
private fun ExampleFacto2One1(pagerState: PagerState, nextPage: Int) {
    val scope = rememberCoroutineScope()
    val modifier = Modifier.fillMaxWidth()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        FormulaFactorizacionOne()
        bodyLarge(text = stringResource(id = R.string.desarrollo), modifier = Modifier)
        Row(horizontalArrangement = Arrangement.Center, modifier = modifier) {
            ExponenteCuadrado(
                baseOne = "x",
                exponenOne = "2",
                next = " + 5x +",
                baseTwo = "4",
                exponenTwo = ""
            )
            bodyLarge(text = " = (x + 1)(x + 4)", modifier = Modifier)
        }
        SpaceH()
        bodyLarge(text = stringResource(id = R.string.Procedimiento), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box2D2_one), modifier = Modifier)
        ExponenteCuadrado(
            baseOne = "x",
            exponenOne = "2",
            next = " + ax + bx + ",
            baseTwo = "4",
            exponenTwo = ""
        )
        bodyMedium(text = stringResource(id = R.string.Box2D2_two), modifier = Modifier)
        bodyLarge(text = "1° par -> 1, 4\n\n2° par -> 2, 2", modifier = align)
        bodyMedium(text = stringResource(id = R.string.Box2D2_three), modifier = Modifier)
        bodyLarge(
            text = "Suma del 1° par -> 1 + 4 = 5\n\nSuma del 2° par -> 2 + 2 = 4",
            modifier = align
        )
        bodyMedium(text = stringResource(id = R.string.Box2D2_four), modifier = Modifier)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            ExponenteCuadrado(
                baseOne = "x",
                exponenOne = "2",
                next = " + (1 + 4)x + ",
                baseTwo = "1",
                exponenTwo = "",
                fontSize = 18.sp
            )
            By()
            bodyLarge(text = "4 = (x + 1)(x + 4)", modifier = Modifier, fontSize = 18.sp)
        }
        btnExample(
            onClick = {
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
fun LazyExerciseFacto2One5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseFacto2One5(
                pagerState,
                topicVM,
                scope,
                userStateVM
            )
        }
    }
}

@Composable
private fun ExerciseFacto2One5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listOne = listOf("(x ", state.onValueChange, ")(x ", state.onValueChange, ")")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        if (state.onValueChange == "-2" || state.onValueChange == "-3" && state.onValueChangeTwo == "-3" || state.onValueChangeTwo == "-2") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Ej. (x+a)(x+b)", Toast.LENGTH_SHORT).show()
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        SpaceH()
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_factotwo_four_dark,
            painterL = R.drawable.ejer_factotwo_four_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
            listOne.forEach { s ->
                bodyLarge(text = s, modifier = align)
            }
        }
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            OutlinedTextString(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(it) },
                keyboardType = KeyboardType.Text,
                placeholder = { Text(text = "a") }
            )
            OutlinedTextString(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(it) },
                keyboardType = KeyboardType.Text,
                placeholder = { Text(text = "a") }
            )
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto2One6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2One6(navController, topicVM) }
    }
}

@Composable
private fun ExerciseFacto2One6(
    navController: NavController,
    topicVM: TopicVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun check() {
        if (state.onValueChange == "(x+1)(x-8)" || state.onValueChange == "(x-8)(x+1)") {
            topicVM.checkFinishString(true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.checkFinishString(false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        SpaceH()
        ExponenteLarge(
            b1 = "x",
            b2 = " - 7x - ",
            b3 = "8",
            e1 = "2",
            e2 = "",
            e3 = "",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        HorizontalDivider()
        if (state.onValueChange.isEmpty()) {
            bodyLarge(text = "Ej. (x+a)(x+b)", modifier = align)
        } else {
            bodyLarge(text = state.onValueChange, modifier = align)
        }
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(it) },
            keyboardType = KeyboardType.Text,
            placeholder = null
        )
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.facto2Two
        )
    }
}