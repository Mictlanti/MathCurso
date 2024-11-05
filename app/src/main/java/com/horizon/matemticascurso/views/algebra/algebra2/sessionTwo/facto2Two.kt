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
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.horizon.matemticascurso.AppScreens
import com.horizon.matemticascurso.R
import com.horizon.matemticascurso.analyticsTrackScreen
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SpecialExponent
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.SpecialExponenteCuadrado
import com.horizon.matemticascurso.views.components.BtnCheck
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
fun Facto2TwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 5 })
    val showExample = remember { mutableStateOf(false) }
    val nextPage = (pagerState.currentPage + 1).coerceIn(0, pagerState.pageCount - 1)
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "factorizacion 2 sesion2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Factorización",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseFacto2Two1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseFacto2Two2(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseFacto2Two3(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseFacto2Two4(modifier, pagerState, topicVM, scope)
                4 -> LazyExerciseFacto2Two5(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 5,
        spaceByBoxes = 50.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseFacto2Two1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2Two1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto2Two1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun check() {
        if (state.onValueChange == "(x+5)(x+3)" || state.onValueChange == "(x+3)(x+5)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(
            text = stringResource(id = R.string.factoriza),
            modifier = Modifier.align(Alignment.Start)
        )
        SpaceH()
        ExponenteCuadrado(
            baseOne = "x",
            exponenOne = "",
            next = " + 8x + ",
            baseTwo = "15 = ",
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
fun LazyExerciseFacto2Two2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2Two2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto2Two2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun check() {
        if (state.onValueChange == "3(x+4)(x+1)" || state.onValueChange == "3(x+1)(x+4)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(
            text = stringResource(id = R.string.factoriza),
            modifier = Modifier.align(Alignment.Start)
        )
        SpaceH()
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
            ExponenteCuadrado(
                baseOne = "3x",
                exponenOne = "2",
                next = " + 5x",
                baseTwo = " + 12 =",
                exponenTwo = ""
            )
            ExponenteCuadrado(
                baseOne = "3(x",
                exponenOne = "2",
                next = " + 5x +",
                baseTwo = "4)",
                exponenTwo = ""
            )
        }
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
fun LazyExerciseFacto2Two3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2Two3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto2Two3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun check() {
        if (state.onValueChange == "-2(x+5)(x-6)" || state.onValueChange == "-2(x-6)(x+5)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.CenterHorizontally))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "-2x",
            exponenOne = "2",
            next = " + 2x + ",
            baseTwo = "60 =",
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
fun LazyExerciseFacto2Two4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2Two4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto2Two4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        if (state.onValueChange == "xy(x+y+1)" || state.onValueChange == "xy(1+x+y)" || state.onValueChange == "xy(y+x+1)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
            SpecialExponenteCuadrado(
                baseOne = "x",
                exponenOne = "2",
                baseNext = "y + xy",
                exponenteNext = "2",
                baseTwo = " + xy",
                exponenTwo = ""
            )
            bodyLarge(text = " = ", modifier = Modifier)
        }
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
fun LazyExerciseFacto2Two5(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto2Two5(navController, topicVM) }
    }
}

@Composable
private fun ExerciseFacto2Two5(
    navController: NavController,
    topicVM: TopicVM,
    context: Context = LocalContext.current,
) {

    val state by topicVM.state.collectAsState()
    fun check() {
        if (state.onValueChange == "6ab(ab+2)" || state.onValueChange == "6ab(2+ab)") {
            topicVM.checkFinishString(true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.checkFinishString(true)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        SpecialExponenteCuadrado(
            baseOne = "6a",
            exponenOne = "2",
            baseNext = "b",
            exponenteNext = "2",
            baseTwo = " + 12ab = ",
            exponenTwo = ""
        )
        SpaceH()
        HorizontalDivider()
        if (state.onValueChange.isEmpty()) {
            bodyLarge(text = "Tu respuesta va aquí", modifier = align)
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
            destination = AppScreens.facto2Three
        )
    }
}