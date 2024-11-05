@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionTwo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Grafics
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.bodySmall
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
fun GraficaRectaTwoScreenRoute(
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

    analyticsTrackScreen(name = "grafica recta sesion 2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Gráfica de la recta",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseGrafiRectaTwo1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseGrafiRectaTwo2(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseGrafiRectaTwo3(
                    modifier,
                    pagerState,
                    topicVM, scope
                )

                3 -> LazyExerciseGrafiRectaTwo4(modifier, pagerState, topicVM, scope)
                4 -> LazyExerciseGrafiRectaTwo5(modifier, pagerState, nextPage, userStateVM)
                5 -> LazyExerciseGrafiRectaTwo6(modifier, pagerState, topicVM, scope)
                6 -> LazyExerciseGrafiRectaTwo7(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 7,
        spaceByBoxes = 20.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseGrafiRectaTwo1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaTwo1(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseGrafiRectaTwo1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("y = 2x - 3", "y = -3x + 2")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.grafiRectaTwo_one), modifier = Modifier)
        bodyLarge(text = "m = 7\nb = 2", modifier = align)
        bodyMedium(text = stringResource(id = R.string.grafiRectaTwo_two), modifier = Modifier)
        HorizontalDivider()
        bodyLarge(text = stringResource(id = R.string.calculaGrafi), modifier = Modifier)
        bodyLarge(text = "m = 2\nb = -3", modifier = align)
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_seven), modifier = Modifier)
        bodyLarge(text = "y = mx + b", modifier = align)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaTwo2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaTwo2(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseGrafiRectaTwo2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("y = 2x - 7", "y = -7x + 2")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.calculaGrafi), modifier = Modifier)
        bodyLarge(text = "m = -7\nb = 2", modifier = align)
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_seven), modifier = Modifier)
        bodyLarge(text = "y = mx + b", modifier = align)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier.weight(1f),
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
fun LazyExerciseGrafiRectaTwo3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseGrafiRectaTwo3(
                pagerState, topicVM, scope
            )
        }
    }
}

@Composable
fun ExerciseGrafiRectaTwo3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "y=-2x+5" || state.onValueChange == "y= -2x+5" || state.onValueChange == "y=-2x + 5") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.calculaGrafi), modifier = Modifier)
        bodyLarge(text = "m = -2\nb = 5", modifier = align)
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_seven), modifier = Modifier)
        bodyLarge(text = "y = mx + b", modifier = align)
        HorizontalDivider()
        Spacer(modifier = Modifier.height(5.dp))
        bodyLarge(text = state.onValueChange, modifier = align)
        OutlinedTextString(
            value = state.onValueChange,
            onValueChange = { topicVM.onValueChangeOne(onValue = it) },
            keyboardType = KeyboardType.Text,
            placeholder = { Text(text = "y=mx+b") }
        )
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaTwo4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaTwo4(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseGrafiRectaTwo4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("y = 3x + 1", "y = 3x")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        bodyMedium(text = stringResource(id = R.string.grafiRectaTwo_three), modifier = Modifier)
        bodySmall(text = stringResource(id = R.string.Box2B4_three), modifier = Modifier)
        Grafics(
            painterR = R.drawable.img_graficrectatwo_one_unit,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaTwo5(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
    userStateVM: UserStateVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaTwo5(pagerState, nextPage, userStateVM) }
    }
}

@Composable
fun ExerciseGrafiRectaTwo5(pagerState: PagerState, nextPage: Int, userStateVM: UserStateVM) {

    val scope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.grafiRectaTwo_five), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.img_grafirectatwo_two_dark,
            painterL = R.drawable.img_grafirectatwo_two_light,
            modifier = align
        )
        bodyMedium(text = stringResource(id = R.string.grafiRectaTwo_six), modifier = Modifier)
        bodyLarge(text = "b = 1", modifier = align)
        Grafics(painterR = R.drawable.img_grafirectatwo_two_one_uni, modifier = align)
        bodyMedium(text = stringResource(id = R.string.grafiRectaTwo_six_one), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.img_grafirectatwo_three_dark,
            painterL = R.drawable.img_grafirectatwo_three_light,
            modifier = align
        )
        bodyMedium(
            text = stringResource(id = R.string.grafiRectaTwo_seven),
            modifier = Modifier.align(Alignment.Start)
        )
        Grafics(painterR = R.drawable.img_grafirectatwo_three_one_unit, modifier = align)
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
fun LazyExerciseGrafiRectaTwo6(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaTwo6(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseGrafiRectaTwo6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("Verdadero", "Falso")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        titleMedium(text = stringResource(id = R.string.VoF))
        bodyMedium(text = stringResource(id = R.string.grafiRectaTwo_eight), modifier = Modifier)
        Grafics(painterR = R.drawable.img_grafirectatwo_four_dark)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = Modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaTwo7(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaTwo7(navController, topicVM) }
    }
}

@Composable
fun ExerciseGrafiRectaTwo7(navController: NavController, topicVM: TopicVM) {

    val listOne = listOf("Verdadero", "Falso")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.VoF))
        bodyMedium(text = stringResource(id = R.string.grafiRectaTwo_eight), modifier = Modifier)
        Grafics(painterR = R.drawable.img_grafirectatwo_five_unit)
        Spacer(modifier = Modifier.height(5.dp))
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
            destination = AppScreens.grafiRectaThree
        )
    }
}