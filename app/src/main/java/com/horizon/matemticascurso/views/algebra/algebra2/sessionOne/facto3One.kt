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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Grafics
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.FormulaFactoTwo
import com.horizon.matemticascurso.views.components.OutlinedText
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleLarge
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.vms.TopicVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Facto3OneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val showExample = remember { mutableStateOf(false) }
    val pagerState = rememberPagerState(pageCount = { 6 })
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "factorizacion 3 sesion1", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Factorización",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExampleFacto3One1(modifier, pagerState, nextPage)
                1 -> LazyExerciseFacto3One1(
                    modifier,
                    pagerState,topicVM, scope
                )

                2 -> LazyExerciseFacto3One2(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseFacto3One3(
                    modifier,
                    pagerState,topicVM, scope
                )

                4 -> LazyExerciseFacto3One4(modifier, pagerState, topicVM, scope)
                5 -> LazyExerciseFacto3One5(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 40.dp,
        showExample = { showExample.value = true }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyExampleFacto3One1(modifier: Modifier, pagerState: PagerState, nextPage: Int) {
    LazyColumn(modifier = modifier) {
        item { ExampleFacto3One1(pagerState, nextPage) }
    }
}

@Composable
fun ExampleFacto3One1(pagerState: PagerState, nextPage: Int) {
    val scope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        FormulaFactoTwo()
        titleMedium(text = stringResource(id = R.string.desarrollo))
        ExponenteCuadrado(
            baseOne = "3x",
            exponenOne = "2",
            next = " + 5x + 2 = ",
            baseTwo = "(3x + 2)(x + 1)",
            exponenTwo = ""
        )
        bodyMedium(text = stringResource(id = R.string.Box1D3_one), modifier = Modifier)
        Grafics(painterR = R.drawable.ejem_factothree_two, modifier = align)
        bodyMedium(text = stringResource(id = R.string.Box1D3_two), modifier = Modifier)
        Grafics(painterR = R.drawable.ejem_factothree_three, modifier = align)
        bodyMedium(text = stringResource(id = R.string.Box1D3_three), modifier = Modifier)
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
fun LazyExerciseFacto3One1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseFacto3One1(
                pagerState,
                topicVM, scope
            )
        }
    }
}

@Composable
private fun ExerciseFacto3One1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange== "5" && state.onValueChangeTwo == "1") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, true)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        FormulaFactoTwo()
        bodyMedium(text = stringResource(id = R.string.Box1D2_two), modifier = Modifier)
        ExponenteCuadrado(
            baseOne = "2x",
            exponenOne = "2",
            next = " + 7x + ",
            baseTwo = "5",
            exponenTwo = ""
        )
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            forTitleorBtn(textForTitle = "a = 2")
            Box {
                Row {
                    bodyLarge(text = "b = ", modifier = Modifier)
                    bodyLarge(text = state.onValueChange, modifier = Modifier)
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.multiplicacion_cruzada_unit),
            contentDescription = "image",
            modifier = modifier
        )
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Row {
                    bodyLarge(text = "c = ", modifier = Modifier)
                    bodyLarge(text = state.onValueChangeTwo, modifier = Modifier)
                }
            }
            forTitleorBtn(textForTitle = "d = 1")
        }
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedText(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(it) },
                placeholder = { Text(text = "b = ") }
            )
            OutlinedText(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(it) },
                placeholder = { Text(text = "c = ") }
            )
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3One2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3One2(pagerState,topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3One2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("Verdadero", "Falso")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        SpaceH()
        Grafics(painterR = R.drawable.ejer_factothree_two)
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
fun LazyExerciseFacto3One3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseFacto3One3(
                pagerState, topicVM, scope
            )
        }
    }
}

@Composable
private fun ExerciseFacto3One3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        if (state.onValueChange == "2" && state.onValueChangeTwo == "2") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, true)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        FormulaFactoTwo()
        bodyLarge(
            text = stringResource(id = R.string.factoriza),
            modifier = Modifier.align(Alignment.Start)
        )
        ExponenteCuadrado(
            baseOne = "4x",
            exponenOne = "2",
            next = " - 28xy + ",
            baseTwo = "49y",
            exponenTwo = "2"
        )
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Row {
                    bodyLarge(text = "a = ", modifier = Modifier)
                    bodyLarge(text = state.onValueChange, modifier = Modifier)
                }
            }
            bodyLarge(text = "b = 7", modifier = Modifier)
        }
        Image(
            painter = painterResource(id = R.drawable.multiplicacion_cruzada_unit),
            contentDescription = "image",
            modifier = modifier
        )
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Row {
                    bodyLarge(text = "c = ", modifier = Modifier)
                    bodyLarge(text = state.onValueChangeTwo, modifier = Modifier)
                }
            }
            bodyLarge(text = "d = 7", modifier = Modifier)
        }
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            OutlinedText(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(it) },
                placeholder = { Text(text = "a = ") }
            )
            OutlinedText(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(it) },
                placeholder = { Text(text = "c = ") }
            )
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3One4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3One4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3One4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("(2x - 7y)", "(x + y)")
    val listTwo = listOf("(x+7y)(2x-7y)", "(7x-y)(2x-7y)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }


    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        FormulaFactoTwo()
        bodyLarge(
            text = stringResource(id = R.string.factoriza),
            modifier = Modifier.align(Alignment.Start)
        )
        SpaceH()
        ExponenteCuadrado(
            baseOne = "4x",
            exponenOne = "2",
            next = " - 28xy + ",
            baseTwo = "49y",
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
                ) { bodyLarge(text = s, modifier = Modifier, fontSize = 23.sp) }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3One5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3One5(navController, topicVM) }
    }
}

@Composable
private fun ExerciseFacto3One5(navController: NavController, topicVM: TopicVM) {

    val listOne = listOf("(x-4)(x+5)", "(x+5)(x+4)")
    val listTwo = listOf("x(x-1)", "(5x+1)(3x+8)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkFinishInt(4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        FormulaFactoTwo()
        bodyLarge(
            text = stringResource(id = R.string.factoriza),
            modifier = Modifier.align(Alignment.Start)
        )
        Image(
            painter = painterResource(id = R.drawable.ejer_factothree_four),
            contentDescription = "Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
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
            destination = AppScreens.facto3Two
        )
    }
}