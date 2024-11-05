@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.sessionThree

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
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedText
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnExample
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SistemEcua1ThreeScreenRoute(
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

    analyticsTrackScreen(name = "sistema ecuaciones 1 sesion3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Sistema de ecuaciones",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseSistemEcua1Three1(
                    pagerState,
                    modifier,
                    topicVM,
                    scope,
                    userStateVM
                )

                1 -> LazyExerciseSistemEcua1Three3(
                    pagerState,
                    modifier,
                    topicVM,
                    scope,
                    userStateVM
                )

                2 -> LazyExerciseSistemEcua1Three4(
                    modifier,
                    pagerState,
                    topicVM,
                    scope,
                    userStateVM
                )

                3 -> LazyExampleSistemEcua1Three1(modifier, pagerState, nextPage, userStateVM)
                4 -> LazyExerciseSistemEcua1Three5(
                    pagerState,
                    modifier,
                    topicVM,
                    scope,
                    userStateVM
                )

                5 -> LazyExerciseSistemEcua1Three6(
                    pagerState,
                    modifier,
                    topicVM,
                    scope,
                    userStateVM
                )

                6 -> LazyExerciseSistemEcua1Three7(
                    pagerState,
                    modifier,
                    topicVM,
                    scope,
                    userStateVM
                )

                7 -> LazyExerciseSistemEcua1Three8(
                    pagerState,
                    modifier,
                    topicVM,
                    navController,
                    userStateVM
                )
            }
        },
        pagerState,
        repeatBoxes = 8,
        spaceByBoxes = 20.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseSistemEcua1Three1(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Three1(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Three1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listAnswerOne = listOf("(x,y)=(2,1)", "(x,y)=(1,2)")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.desaCorrecta), modifier = Modifier)
        SpaceH()
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_three_one_dark,
            painterL = R.drawable.ejer_sistemecuaone_three_one_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
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
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseSistemEcua1Three3(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Three3(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Three3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        bodyMedium(text = stringResource(id = R.string.sistemEcua1Three_four), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_one_dark,
            painterL = R.drawable.ejer_sistemecuaone_one_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyLarge(text = "(x, y) = (1, 6)", modifier = Modifier.align(Alignment.CenterHorizontally))
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
fun LazyExerciseSistemEcua1Three4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Three4(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Three4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val listOne = listOf("Verdadero", "Falso")
    val recycleModi = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        bodyMedium(text = stringResource(id = R.string.sistemEcua1Three_four), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_three_two_dark,
            painterL = R.drawable.ejer_sistemecuaone_three_two_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyLarge(text = "(x, y) = (1, 6)", modifier = Modifier.align(Alignment.CenterHorizontally))
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
fun LazyExampleSistemEcua1Three1(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExampleSistemEcua1Three1(pagerState, nextPage, userStateVM) }
    }
}

@Composable
private fun ExampleSistemEcua1Three1(
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    val scope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.sistemEcua1Three_five), modifier = Modifier)
        bodyMedium(
            text = stringResource(id = R.string.sistemEcua1Three_five_one),
            modifier = Modifier
        )
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.sistem_ecua_three_five_one_dark,
            painterL = R.drawable.sistem_ecua_three_five_one_light,
            modifier = Modifier
        )
        bodyLarge(text = stringResource(id = R.string.Desarrollo), modifier = Modifier)
        bodyMedium(
            text = stringResource(id = R.string.sistemEcua1Three_five_two),
            modifier = Modifier
        )
        bodyMedium(
            text = stringResource(id = R.string.sistemEcua1Three_five_three),
            modifier = Modifier
        )
        bodyMedium(
            text = stringResource(id = R.string.sistemEcua1Three_five_four),
            modifier = Modifier
        )
        bodyMedium(
            text = stringResource(id = R.string.sistemEcua1Three_five_five),
            modifier = Modifier
        )
        bodyLarge(text = "(x, y) = (-5, 4)", modifier = align)
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
fun LazyExerciseSistemEcua1Three5(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Three5(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Three5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "-2x + 14" || state.onValueChange == "-2x+14") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.first))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_three_seven_dark,
            painterL = R.drawable.ejer_sistemecuaone_three_seven_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        SpaceH()
        bodyMedium(text = "Despejando y de 1", modifier = Modifier)
        bodyLarge(
            text = "y = ${state.onValueChange}",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            keyboardType = KeyboardType.Text,
            placeholder = null
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSistemEcua1Three6(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Three6(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Three6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "-6x + 34" || state.onValueChange == "-6x+34") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.first))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_three_seven_dark,
            painterL = R.drawable.ejer_sistemecuaone_three_seven_light,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyLarge(text = "y = -2x + 14", modifier = Modifier)
        SpaceH()
        bodyMedium(text = "Despejando y de 2", modifier = Modifier)
        bodyLarge(
            text = "y = ${state.onValueChange}",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            keyboardType = KeyboardType.Text,
            placeholder = null
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSistemEcua1Three7(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Three7(pagerState, topicVM, scope, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Three7(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    userStateVM: UserStateVM
) {

    val list = listOf("x = -2", "x = 5")
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.third))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_three_seven_dark,
            painterL = R.drawable.ejer_sistemecuaone_three_seven_light,
            modifier = align
        )
        bodyLarge(text = "-2x + 14 = -6x + 34", modifier = align)
        SpaceH()
        bodyMedium(text = "Encuentra el valor de x", modifier = Modifier)
        Row(modifier = Modifier.fillMaxWidth()) {
            list.forEachIndexed { index, s ->
                ButtonPerson(
                    activeButtonIndex = index + 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    topicVM
                ) {
                    bodyLarge(text = s, modifier = Modifier)
                }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseSistemEcua1Three8(
    pagerState: PagerState,
    modifier: Modifier,
    topicVM: TopicVM,
    navController: NavController,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseSistemEcua1Three8(pagerState, topicVM, navController, userStateVM) }
    }
}

@Composable
private fun ExerciseSistemEcua1Three8(
    pagerState: PagerState,
    topicVM: TopicVM,
    navController: NavController,
    userStateVM: UserStateVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "5, 4" || state.onValueChange == "5,4") {
            topicVM.checkFinishString(true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.checkFinishString(false)
            Toast.makeText(context, listError.random(), Toast.LENGTH_LONG).show()
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.contestaCorrec))
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejer_sistemecuaone_three_seven_dark,
            painterL = R.drawable.ejer_sistemecuaone_three_seven_light,
            modifier = align
        )
        bodyLarge(text = "x = 5", modifier = align)
        SpaceH()
        bodyMedium(
            text = "Sustituye el valor de x en la ecuación 1 o 2 y expresa tu resultado",
            modifier = Modifier
        )
        bodyLarge(text = "(x,y) = (${state.onValueChange})", modifier = align)
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            keyboardType = KeyboardType.Text,
            placeholder = null
        )
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.sistemaEcua2
        )
    }
}