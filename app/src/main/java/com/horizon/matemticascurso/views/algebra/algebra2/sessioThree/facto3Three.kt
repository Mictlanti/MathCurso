@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.algebra.algebra1.algebra2.sessioThree

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
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
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.CardDouble
import com.horizon.matemticascurso.components.topicsComponents.exerciseComponents.ExponenteCuadrado
import com.horizon.matemticascurso.views.components.BtnCheck
import com.horizon.matemticascurso.views.components.ButtonPerson
import com.horizon.matemticascurso.views.components.OutlinedTextString
import com.horizon.matemticascurso.views.components.SpaceH
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.views.components.bodyLarge
import com.horizon.matemticascurso.views.components.bodyMedium
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.vms.TopicVM
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Facto3ThreeScreenRoute(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 7 })
    val modifier = Modifier.fillMaxSize()
    val showExample = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "factorizacion 3 sesion3", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Factorización",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseFacto3Three1(modifier, pagerState, topicVM, scope)
                1 -> LazyExerciseFacto3Three2(modifier, pagerState, topicVM, scope)
                2 -> LazyExerciseFacto3Three3(modifier, pagerState, topicVM, scope)
                3 -> LazyExerciseFacto3Three4(modifier, pagerState, topicVM, scope)
                4 -> LazyExerciseFacto3Three5(modifier, pagerState, topicVM, scope)
                5 -> LazyExerciseFacto3Three6(modifier, pagerState, topicVM, scope)
                6 -> LazyExerciseFacto3Three7(modifier, navController, topicVM)
            }
        },
        pagerState,
        repeatBoxes = 7,
        spaceByBoxes = 20.dp,
        showExample = { showExample.value = true }
    )
}

@Composable
fun LazyExerciseFacto3Three1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Three1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Three1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listANs = listOf("= [(x + y) + 2]", "= (x + y + 2)")

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "(x + y)",
            exponenOne = "2",
            next = " + 2(x + y)",
            baseTwo = " = ",
            exponenTwo = ""
        )
        listANs.forEach { s ->
            bodyLarge(
                text = "(x + y)$s",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        SpaceH()
        bodyLarge(text = stringResource(id = R.string.Procedimiento), modifier = Modifier)
        bodyMedium(text = stringResource(id = R.string.Box2D4_one), modifier = Modifier)
        ExerciseFacto3Three1One(pagerState, topicVM, scope)
    }
}

@Composable
fun ExerciseFacto3Three1One(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("(x - y)", "x")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        bodyLarge(text = stringResource(id = R.string.idFacto), modifier = Modifier)
        SpaceH()
        ExponenteCuadrado(
            baseOne = "(x - y)",
            exponenOne = "2",
            next = " - ",
            baseTwo = "(x - y)",
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
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3Three2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Three2(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Three2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {


    val modifier = Modifier.fillMaxWidth()
    val listOne = listOf("[1 - (x - y)]", "(x + y)")
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        bodyMedium(text = stringResource(id = R.string.s_facto3_one), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "(x - y)",
            exponenOne = "2",
            next = " - ",
            baseTwo = "(x - y)",
            exponenTwo = ""
        )
        SpaceH()
        bodyLarge(text = stringResource(id = R.string.idFacto_one), modifier = Modifier)
        listOne.forEachIndexed { index, s ->
            ButtonPerson(
                activeButtonIndex = index + 1,
                modifier = modifier,
                topicVM
            ) {
                bodyLarge(text = "(x - y)$s", modifier = Modifier)
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseFacto3Three3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Three3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Three3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {


    val modifier = Modifier.fillMaxWidth()
    val listOne = listOf("(x - y))", "(1 - x + y)")
    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        bodyMedium(
            text = stringResource(id = R.string.idFacto_one_one),
            modifier = Modifier.align(Alignment.Start)
        )
        SpaceH()
        ExponenteCuadrado(
            baseOne = "(x - y)",
            exponenOne = "2",
            next = " - ",
            baseTwo = "(x - y)",
            exponenTwo = ""
        )
        SpaceH()
        bodyLarge(text = stringResource(id = R.string.idFacto_two), modifier = Modifier)
        listOne.forEachIndexed { index, s ->
            ButtonPerson(
                activeButtonIndex = index + 1,
                modifier = modifier,
                topicVM
            ) {
                bodyLarge(text = "(x - y)$s", modifier = Modifier)
            }
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseFacto3Three4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Three4(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Three4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("(a - b)(x + 2)(x - 5)", "(a - b)(x - 1)(x + 3)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier)
        SpaceH()
        ExponenteCuadrado(
            baseOne = "(a - b)(x",
            exponenOne = "2",
            next = " - 5) - (a - b)",
            baseTwo = "(3x + 5) = ",
            exponenTwo = ""
        )
        SpaceH()
        listOne.forEachIndexed { index, s ->
            ButtonPerson(
                index + 1,
                modifier = modifier,
                topicVM
            ) { bodyLarge(text = s, modifier = Modifier) }
        }
        BtnCheck(
            onClick = { check() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3Three5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Three5(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Three5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne =
        listOf("= (x - y)(1 - 1)\n\n= (x - y)0\n\n= 0", "= (x - y)[(x - y) - 1]\n\n= (x - y)(x - y - 1)")

    fun scroll() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.excersiceSevenFacto4), modifier = Modifier)
        SpaceH(size = 20.dp)
        ExponenteCuadrado(
            baseOne = "(x - y)",
            exponenOne = "2",
            next = " - ",
            baseTwo = "(x - y) = ",
            exponenTwo = ""
        )
        SpaceH(size = 20.dp)
        listOne.forEachIndexed { index, s ->
            CardDouble(
                topicVM,
                activeBtn = index + 1
            ) {
                bodyLarge(text = s, modifier = Modifier.padding(10.dp))
            }
        }
        BtnCheck(
            onClick = { scroll() }, topicVM
        )
    }
}

@Composable
fun LazyExerciseFacto3Three6(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Three6(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseFacto3Three6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listOne = listOf("Verdadero", "Falso")
    val listAns = listOf("[(x + y) + 2]", "(x + y + 2)")
    val modifier = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 1)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleMedium(text = stringResource(id = R.string.VoF))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "(x + y)",
            exponenOne = "2",
            next = " + 2",
            baseTwo = "(x + y) =",
            exponenTwo = ""
        )
        listAns.forEach { s ->
            bodyLarge(
                text = " = (x + y)$s",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
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
fun LazyExerciseFacto3Three7(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseFacto3Three7(navController, topicVM) }
    }
}

@Composable
private fun ExerciseFacto3Three7(
    navController: NavController,
    topicVM: TopicVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "-4(x+y)(x-2y)" || state.onValueChange == "-4(x-2y)(x+y)") {
            topicVM.checkFinishString(true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.checkFinishString(false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        val align = Modifier.align(Alignment.CenterHorizontally)
        bodyLarge(text = stringResource(id = R.string.factoriza), modifier = Modifier.align(Alignment.Start))
        SpaceH()
        ExponenteCuadrado(
            baseOne = "9y",
            exponenOne = "2",
            next = " - ",
            baseTwo = "(2x - y)",
            exponenTwo = "2"
        )
        HorizontalDivider()
        SpaceH()
        if (state.onValueChange.isEmpty()) {
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
            destination = AppScreens.raices
        )
    }
}