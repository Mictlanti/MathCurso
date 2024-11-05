@file:OptIn(ExperimentalFoundationApi::class)

package com.horizon.matemticascurso.views.BasesAlge1.sessionTwo

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import com.horizon.matemticascurso.views.components.btnNextTopic
import com.horizon.matemticascurso.views.components.forBodyorExercise
import com.horizon.matemticascurso.views.components.forTitleorBtn
import com.horizon.matemticascurso.views.components.titleLarge
import com.horizon.matemticascurso.views.components.titleMedium
import com.horizon.matemticascurso.views.components.TopBarTopics
import com.horizon.matemticascurso.ui.theme.colorAlpha_dark
import com.horizon.matemticascurso.vms.TopicVM
import com.horizon.matemticascurso.vms.UserStateVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun basicOperationRouteTwo(
    navController: NavController,
    analytics: FirebaseAnalytics,
    topicVM: TopicVM
) {

    val pagerState = rememberPagerState(pageCount = { 8 })
    val showExample = remember { mutableStateOf(false) }
    val recycleModi = Modifier.fillMaxSize()
    val scope = rememberCoroutineScope()

    analyticsTrackScreen(name = "basic operation sesion 2", analytics = analytics)

    TopBarTopics(
        navController,
        titleTopBar = "Operaciones básicas 2",
        topicVM,
        pageContent = { page ->
            when (page) {
                0 -> LazyExerciseBasicOpeTwo1(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                1 -> LazyExerciseBasicOpeTwo2(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                2 -> LazyExerciseBasicOpeTwo3(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                3 -> LazyExerciseBasicOpeTwo4(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                4 -> LazyExerciseBasicOpeTwo5(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                5 -> LazyExerciseBasicOpeTwo6(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                6 -> LazyExerciseBasicOpeTwo7(
                    modifier = recycleModi,
                    pagerState,
                    topicVM,
                    scope
                )

                7 -> LazyExerciseBasicOpeTwo8(
                    modifier = recycleModi,
                    navController,
                    topicVM
                )
            }
        },
        pagerState = pagerState,
        repeatBoxes = 8,
        spaceByBoxes = 20.dp,
        showExample = { showExample.value = true }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyExerciseBasicOpeTwo1(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeTwo1(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseBasicOpeTwo1(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "-" &&
            state.onValueChangeTwo == "+" &&
            state.onValueChangeThree == "-c" &&
            state.onValueChangeFour == "5b-2c" ||
            state.onValueChangeFour == "5b - 2c"
        ) {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty() || state.onValueChangeThree.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        titleLarge(text = stringResource(id = R.string.basicOperationBox5))
        titleMedium(text = stringResource(id = R.string.desarrollo))
        bodyLarge(
            text = "x + (y - z) = x + y - z",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        bodyMedium(text = stringResource(id = R.string.BoxBO5_one), modifier = Modifier)
        bodyLarge(text = stringResource(id = R.string.BoxBO5_two), modifier = Modifier)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyMedium(text = "A) 2a+(-b + 3c)=", modifier = Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            bodyMedium(text = "2a", modifier = Modifier)
            OutlinedTextString(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
            bodyMedium(text = "b", modifier = Modifier)
            OutlinedTextString(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
            bodyMedium(text = "3c", modifier = Modifier)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyLarge(text = "B) (a -c) + 3b = ", modifier = Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            bodyLarge(text = "a ", modifier = Modifier)
            OutlinedTextString(
                value = state.onValueChangeThree,
                onValueChange = { topicVM.onValueChangeThree(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
            bodyLarge(text = " + 3b", modifier = Modifier)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyMedium(text = "B) (2a -a) + (5b - 2c) = ", modifier = Modifier)
            Spacer(modifier = Modifier.width(10.dp))
            bodyMedium(text = "a + ", modifier = Modifier)
            OutlinedTextString(
                value = state.onValueChangeFour,
                onValueChange = { topicVM.onValueChangeFour(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
        }
        BtnCheck(onClick = { scroll() }, topicVM)
        Row {
            titleLarge(text = stringResource(id = R.string.note))
            bodyMedium(text = stringResource(id = R.string.note_one), modifier = Modifier)
        }
    }
}

@Composable
fun LazyExerciseBasicOpeTwo2(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeTwo2(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseBasicOpeTwo2(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "+" && state.onValueChangeTwo == "-" && state.onValueChangeThree == "-c") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty() || state.onValueChangeThree.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {

        val recycleModi = Modifier.align(Alignment.CenterHorizontally)

        titleMedium(text = stringResource(id = R.string.desarrollo))
        bodyLarge(text = "a - (b - c) = a - b + c", modifier = recycleModi)
        bodyMedium(text = stringResource(id = R.string.BocBOT1_one), modifier = recycleModi)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyMedium(text = "A) 2a - (-b + 3c) = ", modifier = recycleModi)
            bodyMedium(text = " 2a ", modifier = recycleModi)
            OutlinedTextString(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
            forBodyorExercise(body = "b ")
            OutlinedTextString(
                value = state.onValueChangeTwo,
                onValueChange = { topicVM.onValueChangeTwo(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
            bodyMedium(text = " 3c", modifier = recycleModi)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyLarge(text = "B) (-a -c) - 3b = ", modifier = recycleModi)
            Spacer(modifier = Modifier.width(10.dp))
            bodyLarge(text = "-a ", modifier = recycleModi)
            OutlinedTextString(
                value = state.onValueChangeThree,
                onValueChange = { topicVM.onValueChangeThree(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = null
            )
            bodyLarge(text = " - 3b", modifier = Modifier)
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeTwo3(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeTwo3(pagerState, topicVM, scope) }
    }
}

@Composable
private fun ExerciseBasicOpeTwo3(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listBtn1 = listOf("-2b - c", "a(b + c)")
    val listBtn2 = listOf("0", "3a - 2b + c")
    val recycleModi = Modifier.fillMaxWidth()
    fun check() {
        topicVM.checkInt(scope, pagerState, 4)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        bodyLarge(
            text = "(2a + a) - (2b - c) =",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            listBtn1.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row {
            listBtn2.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = when (index) {
                        0 -> recycleModi.weight(1f)
                        1 -> recycleModi.weight(2f)
                        else -> recycleModi
                    },
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { check() }, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeTwo4(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeTwo4(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseBasicOpeTwo4(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (state.onValueChange == "6a+5b" || state.onValueChange == "6a + 5b") {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyMedium(text = stringResource(id = R.string.BoxBOT2_one), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bodyLarge(text = "A) (a + 2b) + (5a + 3b) = ", modifier = Modifier)
            OutlinedTextString(
                value = state.onValueChange,
                onValueChange = { topicVM.onValueChangeOne(onValue = it) },
                keyboardType = KeyboardType.Text,
                placeholder = { Text(text = "a+b+c") }
            )
        }
        BtnCheck(onClick = { scroll() }, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeTwo5(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeTwo5(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseBasicOpeTwo5(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {

    val listBtn1 = listOf("2x + y - 2", "12x + 8")
    val listBtn2 = listOf("12x + 2", "-2x - 2")
    val recycleModi = Modifier
        .fillMaxWidth()
        .padding(top = 30.dp, bottom = 5.dp)

    fun check() {
        topicVM.checkInt(scope, pagerState, 3)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        bodyLarge(
            text = "(5x + y - 3)+(7x - y + 5)=",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            listBtn1.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        Row {
            listBtn2.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 3,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { check() }, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeTwo6(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeTwo6(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseBasicOpeTwo6(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {


    val listBtn1 = listOf("-2a - 9b - 4", "-2a - 4")
    val recycleModi = Modifier
        .fillMaxWidth()
        .padding(top = 30.dp, bottom = 5.dp)

    fun check() {
        topicVM.checkInt(scope, pagerState, 2)
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        bodyLarge(
            text = "(5a - 3b) - (7a - 3b + 4) =",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            listBtn1.forEachIndexed { index, s ->
                ButtonPerson(
                    index + 1,
                    modifier = recycleModi.weight(1f),
                    topicVM
                ) { bodyLarge(text = s, modifier = Modifier) }
            }
        }
        BtnCheck(onClick = { check() }, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeTwo7(
    modifier: Modifier,
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeTwo7(pagerState, topicVM, scope) }
    }
}

@Composable
fun ExerciseBasicOpeTwo7(
    pagerState: PagerState,
    topicVM: TopicVM,
    scope: CoroutineScope,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    fun scroll() {
        if (
            state.onValueChange == "-abc" &&
            state.onValueChangeTwo == "abc" &&
            state.onValueChangeThree == "xy"
        ) {
            topicVM.animatedScroll(scope, pagerState, true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty() || state.onValueChangeThree.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.animatedScroll(scope, pagerState, false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val recicleModi = Modifier.align(Alignment.CenterHorizontally)
        titleLarge(text = stringResource(id = R.string.BoxBOT3_one))
        bodyMedium(text = stringResource(id = R.string.BoxBOT3_two), modifier = recicleModi)
        titleMedium(text = stringResource(id = R.string.desarrollo))
        bodyLarge(text = "(a)(b) = ab\n(-a)(b) = -ab", modifier = recicleModi)
        Row {
            titleLarge(text = stringResource(id = R.string.note))
            bodyMedium(text = stringResource(id = R.string.BoxBOT3_three), modifier = recicleModi)
        }
        ExerciseBasicOpeTwo7One(
            modifier = recicleModi,
            valueOne = state.onValueChange,
            onValueOne = { topicVM.onValueChangeOne(onValue = it) },
            valueTwo = state.onValueChangeTwo,
            onValueTwo = { topicVM.onValueChangeTwo(onValue = it) },
            valueThree = state.onValueChangeThree,
            onValueThree = { topicVM.onValueChangeThree(onValue = it) },
            onClick = { scroll() },
            topicVM = topicVM
        )
    }
}

@Composable
fun ExerciseBasicOpeTwo7One(
    modifier: Modifier,
    valueOne: String,
    onValueOne: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    valueTwo: String,
    onValueTwo: (String) -> Unit,
    valueThree: String,
    onValueThree: (String) -> Unit,
    onClick: () -> Unit,
    topicVM: TopicVM
) {

    val listQuestions = listOf("(a)(b)(-c) = ", "(-a)(-b)(c) = ", "(-x)(-y) = ")

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        listQuestions.forEachIndexed { index, s ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                bodyLarge(text = s, modifier = modifier)
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextString(
                    value = when (index) {
                        0 -> valueOne
                        1 -> valueTwo
                        2 -> valueThree
                        else -> valueOne
                    },
                    onValueChange = when (index) {
                        0 -> onValueOne
                        1 -> onValueTwo
                        2 -> onValueThree
                        else -> onValueOne
                    },
                    keyboardType = keyboardType,
                    placeholder = null
                )
            }
        }
        BtnCheck(onClick = onClick, topicVM)
    }
}

@Composable
fun LazyExerciseBasicOpeTwo8(
    modifier: Modifier,
    navController: NavController,
    topicVM: TopicVM
) {
    LazyColumn(modifier = modifier) {
        item { ExerciseBasicOpeTwo8(navController, topicVM) }
    }
}

@Composable
fun ExerciseBasicOpeTwo8(
    navController: NavController,
    topicVM: TopicVM,
    context: Context = LocalContext.current
) {

    val state by topicVM.state.collectAsState()
    val listQuestions = listOf("(x + y + z)a =", "(a -b +c)d =", "(-ab -cd)x =")
    fun scroll() {
        if (
            state.onValueChange == "ax+ay+az" ||
            state.onValueChange == "xa+ya+za" &&
            state.onValueChangeTwo == "ad-bd+cd" ||
            state.onValueChangeTwo == "da-db+dc" &&
            state.onValueChangeThree == "-abx-cdx"
        ) {
            topicVM.checkFinishString(true)
        } else if (state.onValueChange.isEmpty() || state.onValueChangeTwo.isEmpty() || state.onValueChangeThree.isEmpty()) {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        } else {
            topicVM.checkFinishString(false)
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val recycleModi = Modifier.align(Alignment.CenterHorizontally)
        bodyMedium(text = stringResource(id = R.string.BoxBOT4_one), modifier = recycleModi)
        bodyLarge(text = "a + b", modifier = recycleModi)
        Exponente(base = "x", exponente = "3", recycleModi)
        Exponente(base = "2x", exponente = "2", recycleModi)
        titleMedium(text = stringResource(id = R.string.desarrollo))
        bodyLarge(text = "(a - b)c = ac - bc", modifier = recycleModi)
        bodyLarge(text = stringResource(id = R.string.resuelve), modifier = Modifier)
        listQuestions.forEachIndexed { index, s ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                bodyLarge(text = s, modifier = Modifier)
                Spacer(modifier = Modifier.width(5.dp))
                OutlinedTextString(
                    value = when (index) {
                        0 -> state.onValueChange
                        1 -> state.onValueChangeTwo
                        2 -> state.onValueChangeThree
                        else -> state.onValueChange
                    },
                    onValueChange = {
                        when (index) {
                            0 -> {
                                topicVM.onValueChangeOne(onValue = it)
                            }

                            1 -> {
                                topicVM.onValueChangeTwo(onValue = it)
                            }

                            2 -> {
                                topicVM.onValueChangeThree(onValue = it)
                            }
                        }
                    },
                    keyboardType = KeyboardType.Text,
                    placeholder = null
                )
            }
        }
        btnNextTopic(
            onClick = { scroll() },
            topicVM,
            navController,
            destination = AppScreens.simplificacionScreen
        )
    }
}

//Pendiente
@Composable
fun LazyColumnBoxBOTO5(
    modifier: Modifier,
    pagerState: PagerState,
    nextPage: Int,
    navController: NavController
) {
    LazyColumn(modifier = modifier) {
        item { BoxBOT5(pagerState, nextPage, navController) }
    }
}

//Pendiente
@Composable
fun BoxBOT5(
    pagerState: PagerState,
    nextPage: Int,
    navController: NavController
) {

    val Button1 = remember { mutableStateOf(false) }
    val Button2 = remember { mutableStateOf(false) }
    val Button3 = remember { mutableStateOf(false) }
    val Button4 = remember { mutableStateOf(false) }
    val ButtonIfIncorrect = remember { mutableStateOf(false) }
    val ButtonIfCorrect = remember { mutableStateOf(false) }
    LaunchedEffect(key1 = ButtonIfIncorrect.value) {
        if (ButtonIfIncorrect.value) {
            delay(1000)
            Button1.value = false
            Button2.value = false
            Button3.value = false
            Button4.value = false
            ButtonIfIncorrect.value = false
            ButtonIfIncorrect.value = false
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
        titleMedium(text = stringResource(id = R.string.desarrollo))
        forBodyorExercise(body = "(3x - 2y + z)(-2a + b) = -6ax+4ay-2az+3bx-2by+bz")
        forTitleorBtn(textForTitle = stringResource(id = R.string.Procedimiento))
        Box {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                forBodyorExercise(body = "-Multiplicando el monomio -2a por el polinomio 3x-2y+z")
                forTitleorBtn(textForTitle = "-2a(3x-2y+z) = -6ax+4ay-2az")
                forBodyorExercise(body = "-Multiplicando el monomio +b por el polinomio 3x-2y+z")
                forTitleorBtn(textForTitle = "b(3x-2y+z) = 3bx-2by+bz")
                forBodyorExercise(body = "-Comprobando si existen términos comúnes en ambos resultados")
                forTitleorBtn(textForTitle = "(-6ax+4ay-2az) + (3bx-2by+bz")
                forBodyorExercise(body = "- Al no haber términos semejantes, el resultado es: ")
                forTitleorBtn(textForTitle = "-6ax+4ay-2az+3bx-2by+bz")
            }
        }
        forTitleorBtn(textForTitle = stringResource(id = R.string.resuelve))
        Row {
            Button(
                onClick = { Button1.value = !Button1.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (Button1.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button1.value) 10.dp else 0.dp),
                enabled = !Button2.value && !Button3.value && !Button4.value && !ButtonIfIncorrect.value && !ButtonIfCorrect.value
            ) {
                forTitleorBtn(textForTitle = "2ax+bx+5cx-2ay-by-5cy")
            }
            Button(
                onClick = { Button2.value = !Button2.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (Button2.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button2.value) 10.dp else 0.dp),
                enabled = !Button1.value && !Button3.value && !Button4.value && !ButtonIfIncorrect.value && !ButtonIfCorrect.value
            ) {
                forTitleorBtn(textForTitle = "2ax-bx+5cx+2ay+by-5cy")
            }
        }
        Row {
            Button(
                onClick = { Button3.value = !Button3.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (Button3.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button3.value) 10.dp else 0.dp),
                enabled = !Button1.value && !Button2.value && !Button4.value && !ButtonIfIncorrect.value && !ButtonIfCorrect.value
            ) {
                forTitleorBtn(textForTitle = "ax+2bx+3cx+3ay-2by-cy")
            }
            Button(
                onClick = { Button4.value = !Button4.value },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (Button4.value) Color.Magenta else colorAlpha_dark
                ),
                elevation = ButtonDefaults.buttonElevation(if (Button4.value) 10.dp else 0.dp),
                enabled = !Button1.value && !Button2.value && !Button3.value && !ButtonIfIncorrect.value && !ButtonIfCorrect.value
            ) {
                forTitleorBtn(textForTitle = "2a+b+5c-2a-b-5c")
            }
        }
    }
}
