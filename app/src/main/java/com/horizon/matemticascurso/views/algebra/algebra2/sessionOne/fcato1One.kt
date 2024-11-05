@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionOne

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.Color
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
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.ui.theme.colorAlpha_dark
import com.horizon.matemticascurso.ui.theme.md_theme_dark_errorContainer
import com.horizon.matemticascurso.ui.theme.md_theme_dark_primary
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val listErrorTwo = listOf("Escribe sin espacios", "Algo anda mal")

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Facto1OneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 8 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val recycleModifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "factorizacion 1 sesion1", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Factorización",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExampleOneFactoOne1(recycleModifier, pagerState, nextPage)
                1 -> LazyExerciseOneFactoOne1(
                    recycleModifier,
                    pagerState,
                    topicVM,
                    scope
                )

                2 -> LazyExerciseOneFactoOne2(
                    recycleModifier,
                    pagerState, topicVM, scope
                )

                3 -> LazyExerciseOneFactoOne3(
                    recycleModifier,
                    pagerState, topicVM, scope
                )

                4 -> LazyExerciseOneFactoOne4(
                    recycleModifier,
                    pagerState, topicVM, scope
                )

                5 -> LazyExerciseOneFactoOne5(
                    recycleModifier,
                    pagerState, topicVM, scope
                )

                6 -> LazyExerciseOneFactoOne6(
                    recycleModifier,
                    pagerState, topicVM, scope
                )
                7 -> LazyExerciseOneFactoOne7(
                    recycleModifier,
                    navController,
                    topicVM
                )
            }
        },
        pagerState,
        repeatBoxes = 8,
        spaceByBoxes = 13.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExampleOneFactoOne1(modifier: Modifier, pagerState: PagerState, nextPage: Int) {
    LazyColumn(modifier = modifier) {
        item { ExampleOneFactoOne1(pagerState, nextPage) }
    }
}

@Composable
private fun ExampleOneFactoOne1(pagerState: PagerState, nextPage: Int) {
    val scope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.desarrollo))
        bodyLarge(text = "3a(x+y)+3b(x+y) = 3(x+y)(a+b)", modifier = align)
        bodyLarge(text = stringResource(id = R.string.Procedimiento), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box1D1_three), modifier = Modifier)
        bodyLarge(text = "(x + y)", modifier = align)
        bodyMedium(text = stringResource(id = R.string.Box1D1_four), modifier = Modifier)
        bodyLarge(text = "(x + y)(3a + 3b)", modifier = align)
        bodyMedium(text = stringResource(id = R.string.Box1D1_four), modifier = Modifier)
        bodyLarge(text = "3(x + y)(a + b)", modifier = align)
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
fun LazyExerciseOneFactoOne1(
    modifier: Modifier,
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseOneFactoOne1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseOneFactoOne1(
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope
) {

    val listOne = listOf("(x + y)", "(a + b)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.idFacto), modifier = Modifier)
        SpaceH()
        bodyLarge(
            text = "9a(x + y) + 9b(x + y) =",
            modifier = Modifier.align(Alignment.CenterHorizontally)
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
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseOneFactoOne2(
    modifier: Modifier,
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseOneFactoOne2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseOneFactoOne2(
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope
) {

    val listOne = listOf("9x(a+b)(x+y)y", "(x+y)(9a+9b)")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = "Según lo anterior", modifier = Modifier)
        bodyLarge(text = "9a(x + y) + 9b(x + y) =", modifier = align)
        bodyMedium(text = stringResource(id = R.string.idFacto_one), modifier = Modifier)
        Row {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = modifier.weight(1f),
                    topicVM
                ) {
                    bodyMedium(text = s, modifier = Modifier)
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseOneFactoOne3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseOneFactoOne3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseOneFactoOne3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("9x(a+b)y", "9(x+y)(a+b)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.idFacto_two), modifier = Modifier)
        SpaceH()
        bodyLarge(
            text = "(x+y)(9a+9b) =",
            modifier = Modifier.align(Alignment.CenterHorizontally)
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
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseOneFactoOne4(
    modifier: Modifier,
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseOneFactoOne4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseOneFactoOne4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("(x+y)(a+b)", "4(x+y)(a+b)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        SpaceH()
        bodyLarge(
            text = "4a(x + y) + 4b(x + y) =",
            modifier = Modifier.align(Alignment.CenterHorizontally)
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
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseOneFactoOne5(
    modifier: Modifier,
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseOneFactoOne5(
                pagerState, topicVM, scope
            )
        }
    }
}

@Composable
private fun ExerciseOneFactoOne5(
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        if (state.onValueChange == "x+y" || state.onValueChange == "x + y") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.idFacto), modifier = align)
        bodyLarge(text = "9ax(x + y) + 12bx(x + y) =", modifier = align)
        Divider(modifier = modifier)
        bodyLarge(
            text = "(${state.onValueChange})",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
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
fun LazyExerciseOneFactoOne6(
    modifier: Modifier,
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseOneFactoOne6(
                pagerState,
                topicVM, scope
            )
        }
    }
}

@Composable
private fun ExerciseOneFactoOne6(
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listOne = listOf("( ", state.onValueChange, " )( ", state.onValueChangeTwo, " )")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        if (state.onValueChange == "x+y" && state.onValueChangeTwo == "9ax+12bx") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, listErrorTwo.random(), Toast.LENGTH_SHORT).show()
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.idFacto_one_one), modifier = align)
        bodyLarge(text = "9ax(x + y) + 12bx(x + y) =", modifier = align)
        Divider(modifier = modifier)
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterHorizontally)
        ) {
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
                placeholder = null
            )
            OutlinedTextString(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseOneFactoOne7(
    modifier: Modifier,
    navController: NavController, topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseOneFactoOne7(navController, topicVM) }
    }
}

@Composable
private fun ExerciseOneFactoOne7(
    navController: NavController,
    topicVM: TopicVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listOne = listOf(state.onValueChange, "(x + y)", "( ", state.onValueChangeTwo, " )")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        if (state.onValueChange == "3x" || state.onValueChangeTwo == "a+4b") {
            topicVM.checkFinishString(true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, listErrorTwo.random(), Toast.LENGTH_SHORT).show()
            topicVM.checkFinishString(false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.contestaCorrec), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.idFacto_one_two), modifier = Modifier)
        bodyLarge(text = "(9ax + 12bx)(x +y)", modifier = align)
        HorizontalDivider()
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterHorizontally)
        ) {
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
                placeholder = null
            )
            OutlinedTextString(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
        }
        btnNextTopic(
            onClick = { check() },
            topicVM,
            navController,
            destination = AppScreens.facto1Two
        )
    }
}