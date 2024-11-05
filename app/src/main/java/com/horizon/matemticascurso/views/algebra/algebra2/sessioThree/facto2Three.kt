@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessioThree

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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.Exponente
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteLarge
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SpecialExponenteCuadrado
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.FormulaDiferenciaCuadrados
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Facto2ThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 5 })
    val modifier = Modifier.fillMaxSize()
    val showExample = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "factorizacion 2 sesion3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Factorización",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseFacto2Three1(
                    modifier,
                    pagerState,
                    topicVM,
                    scope
                )

                1 -> LazyExerciseFacto2Three2(
                    modifier,
                    pagerState,
                    topicVM,
                    scope
                )

                2 -> LazyExerciseFacto2Three3(
                    modifier,
                    pagerState,
                    topicVM,
                    scope
                )

                3 -> LazyExerciseFacto2Three4(
                    modifier,
                    pagerState,
                    topicVM,
                    scope
                )

                4 -> LazyExerciseFacto2Three5(
                    modifier,
                    navController,
                    topicVM
                )
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 55.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseFacto2Three1(
    modifier: Modifier,
    pagerState: PagerState, topicVM: TopicVM, scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseFacto2Three1(
                pagerState, topicVM, scope
            )
        }
    }
}

@Composable
private fun ExerciseFacto2Three1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        if (state.onValueChange == "3(x+2)(2a+b)" || state.onValueChange == "3(2a+b)(x+2)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        SpaceH()
        bodyLarge(text = "6ax + 12a + 3bx + 6b =", modifier = align)
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
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto2Three2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2Three2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto2Three2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("(2x - 7y)", "(x + 7y)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        FormulaDiferenciaCuadrados()
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        SpaceH()
        ExponenteCuadrado(
            baseOne = "4x",
            exponenOne = "",
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
                ) {
                    Exponente(base = s, exponente = "2", modifier = Modifier)
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto2Three3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2Three3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto2Three3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("6", "3")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        FormulaDiferenciaCuadrados()
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        SpaceH()
        ExponenteLarge(
            b1 = "16x",
            b2 = " - 49y",
            b3 = "z",
            e1 = "6",
            e2 = "2",
            e3 = "4",
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
                    Row {
                        SpecialExponenteCuadrado(
                            baseOne = if (index == 0) "(16x" else "(4x",
                            exponenOne = s,
                            baseNext = if (index == 0) " - 49y" else " - 7y",
                            exponenteNext = if(index == 0) "2" else "",
                            baseTwo = if(index == 0) "Z" else "",
                            exponenTwo = if(index == 0) "4" else "2"
                        )
                        if(index == 1) {
                            Exponente(base = ")", exponente = "2", modifier = Modifier)
                        } else if(index == 0) {
                            bodyLarge(
                                text = ")",
                                modifier = Modifier
                            )
                        }
                    }
                }
            }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto2Three4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item {
            ExerciseFacto2Thre4(
                pagerState, topicVM, scope
            )
        }
    }
}

@Composable
private fun ExerciseFacto2Thre4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun check() {
        if (state.onValueChange == "3a(x+1)(x-4)" || state.onValueChange == "3a(x-4)(x+1)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        SpaceH()
        ExponenteCuadrado(
            baseOne = "3ax",
            exponenOne = "2",
            next = " - 9ax - ",
            baseTwo = "12a = ",
            exponenTwo = ""
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
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto2Three5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2Thre5(navController, topicVM) }
    }
}

@Composable
private fun ExerciseFacto2Thre5(
    navController: NavController,
    topicVM: TopicVM,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    fun check() {
        if (state.onValueChange == "2(x+2)(x-6)" || state.onValueChange == "2(x-6)(x+2)") {
            topicVM.checkFinishString( true)
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
        ExponenteCuadrado(
            baseOne = "x",
            exponenOne = "2",
            next = " - 8x - ",
            baseTwo = "24",
            exponenTwo = ""
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
            destination = AppScreens.facto3One
        )
    }
}