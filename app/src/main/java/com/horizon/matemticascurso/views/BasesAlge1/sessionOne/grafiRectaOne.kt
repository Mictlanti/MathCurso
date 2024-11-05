@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionOne

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
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
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Grafics
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ImageAnimation
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.alertBtnStyle
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
fun GraficaRectaoneScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM,
    userStateVM: UserStateVM
) {

    val pagerState = rememberPagerState(pageCount = { 7 })
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val showExample = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "Gráfica recta session 1", analytics = analytics)
    alertBtnStyle(
        PartiallyExpanded = true,
        showExample = showExample.value,
        onDismissRequest = { showExample.value = false },
        content = { exampleAlertBtnGR() }
    )

    TopBarTopics(
        navController,
        titleTopBar = "Gráfica de la recta",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExampleGrafiRectaOne1(modifier, pagerState, nextPage, userStateVM)
                1 -> LazyExerciseGrafiRectaOne1(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseGrafiRectaOne2(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseGrafiRectaOne3(modifier, pagerState, topicVM, scope)
                4 -> LazyExerciseGrafiRectaOne4(modifier, pagerState, topicVM, scope)
                5 -> LazyExerciseGrafiRectaOne5(modifier, pagerState, topicVM, scope)
                6 -> LazyExerciseGrafiRectaOne6(modifier, navController, topicVM)
            }
        },
        pagerState = pagerState,
        repeatBoxes = 7,
        spaceByBoxes = 20.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExampleGrafiRectaOne1(modifier: Modifier, pagerState: PagerState, nextPage: Int, userStateVM: UserStateVM) {
    LazyColumn(modifier = modifier) {
        item { ExampleGrafiRectaOne1(pagerState, nextPage, userStateVM) }
    }
}

@Composable
private fun ExampleGrafiRectaOne1(pagerState: PagerState, nextPage: Int, userStateVM: UserStateVM) {

    val scope = rememberCoroutineScope()

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.Box1B4_one), modifier = Modifier)
        bodyLarge(text = "y = 2x", modifier = align)
        bodyMedium(text = stringResource(id = R.string.Box1B4_two), modifier = Modifier)
        ImageAnimation(
            userStateVM,
            painterD = R.drawable.ejem_grarecone_one_dark,
            painterL = R.drawable.ejem_grarecone_one_light,
            modifier = Modifier
        )
        bodyMedium(text = "Gráficamente", modifier = Modifier)
        Grafics(
            painterR = R.drawable.ejem_grarecone_two_unit,
            modifier = Modifier
                .size(240.dp)
                .padding(10.dp)
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
fun LazyExerciseGrafiRectaOne1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaOne1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseGrafiRectaOne1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("b = nulo", "b = 0")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.Box1B4_three), modifier = Modifier)
        Divider(modifier = modifier)
        bodyMedium(text = stringResource(id = R.string.Box1B4_six), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
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
fun LazyExerciseGrafiRectaOne2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaOne2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseGrafiRectaOne2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("5 unidades", "0 unidades")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.Box1B4_four), modifier = Modifier)
        Divider(modifier = modifier)
        Spacer(modifier = Modifier.height(10.dp))
        bodyMedium(text = stringResource(id = R.string.Box1B4_four_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
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
fun LazyExerciseGrafiRectaOne3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaOne3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseGrafiRectaOne3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("Verdadero", "Falso")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_One), modifier = Modifier)
        Box(modifier = modifier) {
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                bodySmall(text = stringResource(id = R.string.grafiRectaOne_Two), modifier = align)
                Image(
                    painter = painterResource(id = R.drawable.tabla_grafirectaone_one),
                    contentDescription = null,
                    modifier = align
                )
            }
        }
        Divider(modifier = modifier)
        titleMedium(text = stringResource(id = R.string.VoF))
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_Three), modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.tabla_grafirectaone_two),
            contentDescription = null,
            modifier = align
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
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaOne4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaOne4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseGrafiRectaOne4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("Verdadero", "Falso")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        titleMedium(text = stringResource(id = R.string.VoF))
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_four), modifier = Modifier)
        Image(
            painter = painterResource(id = R.drawable.tabla_grafirectaone_three),
            contentDescription = null,
            modifier = align
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    Modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaOne5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaOne5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseGrafiRectaOne5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("m = 5\nb = 3", "m = 3\nb = 5")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_five), modifier = Modifier)
        bodyLarge(text = "y = 5x + 3", modifier = align)
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_six), modifier = Modifier)
        bodySmall(text = stringResource(id = R.string.grafiRectaOne_seven), modifier = Modifier)
        bodyLarge(text = "y = mx + b", modifier = align)
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = modifier) {
            listOne.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier =  Modifier.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseGrafiRectaOne6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseGrafiRectaOne6(navController, topicVM) }
    }
}

@Composable
private fun ExerciseGrafiRectaOne6(
    navController: NavController,
    topicVM: TopicVM
) {

    var activeButtonIndex by remember { mutableIntStateOf(0) }
    val ifCorrect = remember { mutableStateOf(false) }
    val ifIncorrect = remember { mutableStateOf(false) }
    val listOne = listOf("m = 2\nb = 1", "m = 2\nb = -1")
    val modifier = Modifier.fillMaxWidth()
    fun scroll() {
        topicVM.checkFinishInt(1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_five), modifier = Modifier)
        bodyLarge(text = "y = 2x - 1", modifier = align)
        bodyMedium(text = stringResource(id = R.string.grafiRectaOne_six), modifier = Modifier)
        bodySmall(text = stringResource(id = R.string.grafiRectaOne_seven), modifier = Modifier)
        bodyLarge(text = "y = mx + b", modifier = align)
        Spacer(modifier = Modifier.height(15.dp))
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
            destination = AppScreens.grafiRectaTwo
        )
    }
}

@Composable
fun exampleAlertBtnGR() {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)
    ) {
        bodyLarge(
            text = stringResource(id = R.string.exampleOneBO),
            modifier = Modifier
        )
        bodyMedium(
            text = stringResource(id = R.string.exampleAlertBtnGr),
            modifier = Modifier
        )
        bodyLarge(text = "y = mx + b", modifier = Modifier)
        bodyMedium(
            text = stringResource(id = R.string.exampleAlertBtnGr_one),
            modifier = Modifier
        )
        bodyMedium(
            text = stringResource(id = R.string.exampleAlertBtnGr_two),
            modifier = Modifier
        )
    }
}
