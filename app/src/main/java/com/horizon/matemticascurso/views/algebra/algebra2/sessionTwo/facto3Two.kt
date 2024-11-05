@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessionTwo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.FormulaFactoTwo
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.vms.TopicVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Facto3TwoScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val showExample = remember { mutableStateOf(false) }
    val pagerState = rememberPagerState(pageCount = { 6 })
    val modifier = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "factorizacion 2 sesion2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Factorización",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseFacto3Two1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseFacto3Two2(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseFacto3Two3(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseFacto3Two4(modifier, pagerState, topicVM, scope)
                4 -> LazyExerciseFacto3Two5(modifier, pagerState, topicVM, scope)
                5 -> LazyExerciseFacto3Two6(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 6,
        spaceByBoxes = 40.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseFacto3Two1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Two1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Two1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "(2x-1)(x-3)" || state.onValueChange == "(x-3)(2x-1)") {
            topicVM.animatedScroll(scope, pagerState, true)
        }
        else if (state.onValueChange.isEmpty() || state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        FormulaFactoTwo()
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "2x",
            exponenOne = "2",
            next = " - 7x + ",
            baseTwo = "3 = ",
            exponenTwo = ""
        )
        HorizontalDivider()
        SpaceH()
        if(state.onValueChange.isEmpty()){
            bodyLarge(text = stringResource(id = R.string.writeHere), modifier = align)
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
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3Two2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Two2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Two2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "(5x+3)(x+2)" || state.onValueChange == "(x+2)(5x+3)") {
            topicVM.animatedScroll(scope, pagerState, true)
        }
        else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        FormulaFactoTwo()
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "5x",
            exponenOne = "2",
            next = " + 13x + ",
            baseTwo = "6 =",
            exponenTwo = ""
        )
        HorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))
        if(state.onValueChange.isEmpty()){
            bodyLarge(text = stringResource(id = R.string.writeHere), modifier = align)
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
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3Two3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Two3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Two3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "(4x+1)(x+3)" || state.onValueChange == "(x+3)(4x+1)") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context,
                "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, true)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        FormulaFactoTwo()
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "4x",
            exponenOne = "2",
            next = " + 13x + ",
            baseTwo = "3 =",
            exponenTwo = ""
        )
        SpaceH()
        HorizontalDivider()
        if(state.onValueChange.isEmpty()){
            bodyLarge(text = stringResource(id = R.string.writeHere), modifier = align)
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
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3Two4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Two4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Two4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "(3x-2)(x-2)" || state.onValueChange == "(x-2)(3x-2)") {
            topicVM.animatedScroll(scope, pagerState, true)
        }
        else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        FormulaFactoTwo()
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "3x",
            exponenOne = "2",
            next = " - 8x + ",
            baseTwo = "4 =",
            exponenTwo = ""
        )
        SpaceH()
        HorizontalDivider()
        if(state.onValueChange.isEmpty()){
            bodyLarge(text = stringResource(id = R.string.writeHere), modifier = align)
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
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3Two5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Two5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Two5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "(6x+1)(x+5)" || state.onValueChange == "(x+5)(6x+1)") {
            topicVM.animatedScroll(scope, pagerState, true)
        }
        else if (state.onValueChange.isEmpty() || state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, true)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        FormulaFactoTwo()
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "6x",
            exponenOne = "2",
            next = " + 31 + ",
            baseTwo = "5 = ",
            exponenTwo = ""
        )
        SpaceH()
        HorizontalDivider()
        if(state.onValueChange.isEmpty()){
            bodyLarge(text = stringResource(id = R.string.writeHere), modifier = align)
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
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3Two6(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Two6(navController, topicVM) }
    }
}

@Composable
private fun ExerciseFacto3Two6(
    navController: NavController,
    topicVM: TopicVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "(5x+2)(x+3)" || state.onValueChange == "(x+3)(5x+2)") {
            topicVM.checkFinishString(true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.checkFinishString(true)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        FormulaFactoTwo()
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "5x",
            exponenOne = "2",
            next = " + 17x + ",
            baseTwo = "6 =",
            exponenTwo = ""
        )
        SpaceH()
        HorizontalDivider()
        if(state.onValueChange.isEmpty()){
            bodyLarge(text = stringResource(id = R.string.writeHere), modifier = align)
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
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.facto3Three
        )
    }
}